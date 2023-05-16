package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.Entities.Student;
import com.school.management.security.JwtUserDetailsService;
import com.school.management.security.JwtUtil;
import com.school.management.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    private final StudentService studentService;
    private final JwtUtil jwtUtil;
    private final JwtUserDetailsService userDetailsService;

    @Autowired
    public StudentController(StudentService studentService, JwtUtil jwtUtil, JwtUserDetailsService userDetailsService) {
        this.studentService = studentService;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


	@GetMapping("/students")
    public ResponseEntity<Page<Student>> getStudents(
            @RequestParam(value = "className", required = false) String className,
            @RequestParam(value = "teacherFullName", required = false) String teacherFullName,
            Pageable pageable,
            @RequestHeader(value = "Authorization") String tokenHeader
    ) {
        String token = tokenHeader.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        boolean isValidToken = jwtUtil.validateToken(token, userDetails);

        if (!isValidToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Page<Student> students = studentService.getStudents(className, teacherFullName, pageable);
        return ResponseEntity.ok(students);
    }
}

