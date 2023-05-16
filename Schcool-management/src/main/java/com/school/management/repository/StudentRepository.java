package com.school.management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.management.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.classEntity.name = :className AND LOWER(CONCAT(s.classEntity.teacher.firstName, ' ', s.classEntity.teacher.lastName)) LIKE LOWER(CONCAT('%', :teacherFullName, '%'))")
	Page<Student> findByClassAndTeacher(@Param("className") String className,
			@Param("teacherFullName") String teacherFullName, Pageable pageable);

	@Query("SELECT s FROM Student s WHERE s.classEntity.name = :className")
	Page<Student> findByClass(@Param("className") String className, Pageable pageable);

	@Query("SELECT s FROM Student s WHERE LOWER(CONCAT(s.classEntity.teacher.firstName, ' ', s.classEntity.teacher.lastName)) LIKE LOWER(CONCAT('%', :teacherFullName, '%'))")
	Page<Student> findByTeacher(@Param("teacherFullName") String teacherFullName, Pageable pageable);
}