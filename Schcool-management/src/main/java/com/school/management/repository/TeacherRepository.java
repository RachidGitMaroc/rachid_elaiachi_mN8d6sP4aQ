package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.Entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
