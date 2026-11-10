package in.mihirlakhani.crudSpringBootProject.repository;

import in.mihirlakhani.crudSpringBootProject.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Student save(Student student){
        entityManager.persist(student);
        return student;
    }

    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    public Boolean existsById(Long id){
        Student student =  entityManager.find(Student.class, id);
        if (student == null){
            return false;
        }
        return true;
    }

    public Boolean deleteById(Long id){

        if (existsById(id)){
            Student student = findById(id);
            entityManager.remove(student);
            return true;
        }

        return false;
    }



}