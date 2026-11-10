package in.mihirlakhani.crudSpringBootProject.service;

import in.mihirlakhani.crudSpringBootProject.entity.Student;
import in.mihirlakhani.crudSpringBootProject.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student createStudent(Student studentReq){
        //business logic

        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }
    @Transactional
    public Student getStudent(Long id){

        Student studentResponse = studentRepository.findById(id);

        return studentResponse;
    }

//    public List<Student> getAllStudent(){
//
//        List<Student> studentList = studentRepository.findAll();
//
//        return studentList;
//    }
    @Transactional
    public Student updateStudent(Long id, Student student){
        Student studentFound = studentRepository.findById(id);

        if (studentFound == null){
            return null;
        }

        Student studentGot = studentFound;

        studentGot.setAge(student.getAge());
        studentGot.setEmail(student.getEmail());
        studentGot.setName(student.getName());
        studentGot.setRollNo(student.getRollNo());
        studentGot.setSubject(student.getSubject());

        studentRepository.save(studentGot);

        return studentGot;
    }

    @Transactional
    public Boolean deleteStudent(Long id){

        return studentRepository.deleteById(id);

    }



}