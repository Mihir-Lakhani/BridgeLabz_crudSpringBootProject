package in.mihirlakhani.crudSpringBootProject.service;

import in.mihirlakhani.crudSpringBootProject.entity.Student;
import in.mihirlakhani.crudSpringBootProject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        //business logic
        System.out.println("Inside " + this.getClass().getSimpleName());

        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Optional<Student> getStudent(Long id){

        Optional<Student> studentResponse = studentRepository.findById(id);

        return studentResponse;
    }

    public List<Student> getAllStudent(){

        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }

    public Student updateStudent(Long id, Student student){
        Optional<Student> studentFound = studentRepository.findById(id);

        if (!studentFound.isPresent()){
            return null;
        }

        Student studentGot = studentFound.get();

        studentGot.setAge(student.getAge());
        studentGot.setEmail(student.getEmail());
        studentGot.setName(student.getName());
        studentGot.setRollNo(student.getRollNo());
        studentGot.setSubject(student.getSubject());

        studentRepository.save(studentGot);

        return studentGot;
    }

    public Boolean deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }



}