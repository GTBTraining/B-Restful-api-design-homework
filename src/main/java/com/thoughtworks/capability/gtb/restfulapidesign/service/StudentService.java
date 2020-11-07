package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.NoSuchStudentException;
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

    public List<Student> listStudentsByGender(String gender) {
        return StudentRepository.findStudentsByGender(gender);
    }

    public Student listStudentById(Integer id) throws NoSuchStudentException {
        if (StudentRepository.findStudentById(id).size()==1)
    return StudentRepository.findStudentById(id).get(0);
        throw new NoSuchStudentException();
    }

    public void modifyStudent(Student student) {
        StudentRepository.findStudentById(student.getId()).get(0).setName(student.getName());
        StudentRepository.findStudentById(student.getId()).get(0).setGender(student.getGender());
        StudentRepository.findStudentById(student.getId()).get(0).setNote(student.getNote());
    }
}
