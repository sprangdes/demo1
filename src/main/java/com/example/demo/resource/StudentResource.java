package com.example.demo.resource;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id){
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);
        return studentService.getStudent(updatedStudent.getId());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return studentService.getStudent(createdStudent.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable long id){
        if(studentService.deleteStudent(id)){
            return "Student Deleted.";
        }
        return "Student Not Found.";
    }
}
