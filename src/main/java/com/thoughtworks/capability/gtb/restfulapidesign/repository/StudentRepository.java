package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;

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

    public static List<Student> findByGender(String gender) {
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }
}

