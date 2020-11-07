package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.NoSuchStudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    public  StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
    }

    @GetMapping("/List")
    public List<Student> listStudents(@RequestParam String gender){
        return studentService.listStudentsByGender(gender);
    }
    @GetMapping
    public Student listStudent(@RequestParam Integer id) throws NoSuchStudentException {
        return studentService.listStudentById(id);
    }

    @PatchMapping
    public void modifyStudent(@RequestBody Student student){
        studentService.modifyStudent(student);
    }
}
