package com.school.management.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.school.management.Entities.Student;
import com.school.management.repository.StudentRepository;
import com.school.management.services.StudentService;

class StudentServiceTest {

	private StudentRepository studentRepository;
	private StudentService studentService;
	private List<Student> testData;

	@BeforeEach
	void setup() {
		studentRepository = mock(StudentRepository.class);
		studentService = new StudentService(studentRepository);

		testData = new ArrayList<>();
		testData.add(new Student(1, "John", "Doe"));
		testData.add(new Student(2, "Jane", "Smith"));
	}

	@Test
	void testGetStudentsByClassAndTeacher() {
		String className = "ClassA";
		String teacherFullName = "John Doe";
		Pageable pageable = Pageable.unpaged();
		Page<Student> expectedPage = new PageImpl<>(testData);

		when(studentRepository.findByClassAndTeacher(className, teacherFullName, pageable)).thenReturn(expectedPage);

		Page<Student> actualPage = studentService.getStudents(className, teacherFullName, pageable);

		assertEquals(expectedPage, actualPage);
	}

	@Test
	void testGetStudentsByClass() {
		String className = "ClassA";
		Pageable pageable = Pageable.unpaged();
		Page<Student> expectedPage = new PageImpl<>(testData);

		when(studentRepository.findByClass(className, pageable)).thenReturn(expectedPage);

		Page<Student> actualPage = studentService.getStudents(className, null, pageable);

		assertEquals(expectedPage, actualPage);
	}

	@Test
	void testGetStudentsByTeacher() {
		String teacherFullName = "John Doe";
		Pageable pageable = Pageable.unpaged();
		Page<Student> expectedPage = new PageImpl<>(testData);

		when(studentRepository.findByTeacher(teacherFullName, pageable)).thenReturn(expectedPage);

		Page<Student> actualPage = studentService.getStudents(null, teacherFullName, pageable);

		assertEquals(expectedPage, actualPage);
	}

	@Test
	void testGetAllStudents() {
		Pageable pageable = Pageable.unpaged();
		Page<Student> expectedPage = new PageImpl<>(testData);

		when(studentRepository.findAll(pageable)).thenReturn(expectedPage);

		Page<Student> actualPage = studentService.getStudents(null, null, pageable);

		assertEquals(expectedPage, actualPage);
	}
}