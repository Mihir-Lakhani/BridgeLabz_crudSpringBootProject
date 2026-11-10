package in.mihirlakhani.crudSpringBootProject.controller;

import in.mihirlakhani.crudSpringBootProject.entity.Student;
import in.mihirlakhani.crudSpringBootProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        System.out.println("Inside " + this.getClass().getSimpleName());

        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity
                    .status(404)
                    .build();
        }

        return ResponseEntity
                .status(200)
                .body(studentResp);
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<List<Student>> getAllStudents(){
//        List<Student> studentList= studentService.getAllStudent();
//
//        if (studentList.isEmpty()){
//            return ResponseEntity
//                    .status(404)
//                    .build();
//        }
//
//        return ResponseEntity
//                .status(200)
//                .body(studentList);
//    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null){
            return ResponseEntity
                    .status(404)
                    .build();
        }

        return ResponseEntity
                .status(200)
                .body(updatedStudent);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){

        Boolean isDeleted = studentService.deleteStudent(id);

        if (!isDeleted){
            return ResponseEntity
                    .status(404)
                    .body("User does Not exist");
        }

        return ResponseEntity
                .status(200)
                .body("User deleted successfully");
    }
}