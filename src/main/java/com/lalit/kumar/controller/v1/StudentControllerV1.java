package com.lalit.kumar.controller.v1;


import com.lalit.kumar.dto.StudentDTO;
import com.lalit.kumar.entity.Student;
import com.lalit.kumar.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/students")
@Validated
@Tag(name = "Student V1", description = "Version 1 - Basic CRUD operations")
@Log4j2
public class StudentControllerV1 {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Add a single student (v1)")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO dto) {
        Student student = convertToEntity(dto);
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get all students (v1)")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = studentService.getAllStudents();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get student by ID (v1)")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return (student != null) ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    private Student convertToEntity(StudentDTO dto) {
        return new Student(dto.getId(), dto.getName(), dto.getGender(), dto.getAge(),
                dto.getCity(), dto.getEmail(), dto.getNumber(),
                dto.getCompany(), dto.getSalary(), dto.getCountry());
    }
}
