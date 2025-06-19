package com.lalit.kumar.controller.v2;

import com.lalit.kumar.dto.PageResponseDTO;
import com.lalit.kumar.dto.StudentDTO;
import com.lalit.kumar.entity.Student;
import com.lalit.kumar.service.StudentService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/students")
@Validated
@Tag(name = "Student V2", description = "Version 2 - Enhanced student APIs with pagination & batch support")
@Log4j2
public class StudentControllerV2 {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Add a single student (v2)")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO dto) {
        Student student = convertToEntity(dto);
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/batch")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Add multiple students (v2)")
    public ResponseEntity<List<Student>> saveAllStudents(@Valid @RequestBody List<@Valid StudentDTO> dtos) {
        List<Student> students = dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
        List<Student> saved = studentService.saveAllStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get all students (v2)")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> list = studentService.getAllStudents();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/pagination")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get paginated students (v2)")
    public ResponseEntity<PageResponseDTO<Student>> getStudentsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Student> pageResult = studentService.getStudentsWithPagination(page, size);
        PageResponseDTO<Student> response = new PageResponseDTO<>();
        response.setContent(pageResult.getContent());
        response.setPageNumber(pageResult.getNumber());
        response.setPageSize(pageResult.getSize());
        response.setTotalElements(pageResult.getTotalElements());
        response.setTotalPages(pageResult.getTotalPages());
        response.setLast(pageResult.isLast());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get student by ID (v2)")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return (student != null) ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update student (v2)")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        Student updated = studentService.updateStudent(id, convertToEntity(dto));
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete student (v2)")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }

    private Student convertToEntity(StudentDTO dto) {
        return new Student(dto.getId(), dto.getName(), dto.getGender(), dto.getAge(),
                dto.getCity(), dto.getEmail(), dto.getNumber(),
                dto.getCompany(), dto.getSalary(), dto.getCountry());
    }
}
