package com.school.management.repositoriesTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.management.Entities.Student;
import com.school.management.repository.StudentRepository;
import com.school.management.services.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;
    
    private List<Student> testData;

    @BeforeEach
    void setup() {
        testData = new ArrayList<>();
        testData.add(new Student(1, "John", "Doe"));
        testData.add(new Student(2, "Jane", "Smith"));
    }


    @Test
    void testFindByClassAndTeacher() {
        String className = "ClassA";
        String teacherFullName = "John Doe";
        Pageable pageable = Pageable.unpaged();
        Page<Student> expectedPage = new PageImpl<>(testData);

        when(studentRepository.findByClassAndTeacher(className, teacherFullName, pageable))
                .thenReturn(expectedPage);

        Page<Student> actualPage = studentService.getStudents(className, teacherFullName, pageable);

        assertEquals(expectedPage, actualPage);
    }

    @Test
    void testFindByClass() {
        String className = "ClassA";
        Pageable pageable = Pageable.unpaged();
        String teacherFullName=null;
        Page<Student> expectedPage = new PageImpl<>(testData);

        when(studentRepository.findByClass(className, pageable)).thenReturn(expectedPage);

        Page<Student> actualPage = studentService.getStudents(className, teacherFullName, pageable);

        assertEquals(expectedPage, actualPage);
    }

    @Test
    void testFindByTeacher() {
    	String className = null;
        String teacherFullName = "John Doe";
        Pageable pageable = Pageable.unpaged();
        Page<Student> expectedPage = new PageImpl<>(testData);

        when(studentRepository.findByTeacher(teacherFullName, pageable)).thenReturn(expectedPage);

        Page<Student> actualPage = studentService.getStudents(className,teacherFullName, pageable);

        assertEquals(expectedPage, actualPage);
    }

    @Test
    void testFindAll() {
    	String className = null;
    	String teacherFullName=null;
        Pageable pageable = Pageable.unpaged();
        Page<Student> expectedPage = new PageImpl<>(testData);

        when(studentRepository.findAll(pageable)).thenReturn(expectedPage);

        Page<Student> actualPage = studentService.getStudents(className,teacherFullName, pageable);;

        assertEquals(expectedPage, actualPage);
    }


}
