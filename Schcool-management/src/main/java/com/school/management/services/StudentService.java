package com.school.management.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.school.management.Entities.Student;
import com.school.management.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getStudents(String className, String teacherFullName, Pageable pageable) {
        if (className != null && teacherFullName != null) {
            return studentRepository.findByClassAndTeacher(className, teacherFullName, pageable);
        } else if (className != null) {
            return studentRepository.findByClass(className, pageable);
        } else if (teacherFullName != null) {
            return studentRepository.findByTeacher(teacherFullName, pageable);
        } else {
            return studentRepository.findAll(pageable);
        }
    }
}