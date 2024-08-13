package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student createStudent(Student student){
        student.setId(null);
        return studentRepository.save(student);
    }

    public boolean deleteStudent(Long id){
        if(studentRepository.findById(id).isEmpty()){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
