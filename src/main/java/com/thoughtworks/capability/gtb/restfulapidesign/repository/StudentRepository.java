package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.NoSuchStudentException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {
    private static final List<Student> studentList = new ArrayList<>();
    public static void add(Student student) {
        studentList.add(student);
    }

    public static void delete(Student student) {
        studentList.remove(student);
    }
    public static List<Student> getAllStudents() {
        return studentList;
    }

    public static List<Student> findStudentsByGender(String gender) {
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public static List<Student> findStudentById(Integer id) {
        return studentList.stream().filter(student -> student.getId().equals(id)).collect(Collectors.toList());
    }
}

