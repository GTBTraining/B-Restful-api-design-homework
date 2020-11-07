package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public void addStudent(Student student) {
        StudentRepository.add(student);
    }

    public void deleteStudent(Student student) {
        StudentRepository.delete(student);
    }

    public List<Student> listStudents(String gender) {
        return StudentRepository.findByGender(gender);
    }
}
