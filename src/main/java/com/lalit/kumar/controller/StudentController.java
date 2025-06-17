package com.lalit.kumar.controller;

import com.lalit.kumar.dto.StudentDTO;
import com.lalit.kumar.entity.Student;
import com.lalit.kumar.service.StudentService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@Validated
@Tag(name = "Student", description = "CRUD operations for managing students")
@Log4j2
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addData")
	@Operation(summary = "Add a single student")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "Student created"),
			@ApiResponse(responseCode = "400", description = "Validation failed")
	})
	public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO dto) {
		log.info("Received request to create student: {}", dto.getName());
		Student student = convertToEntity(dto);
		Student saved = studentService.saveStudent(student);
		log.info("Student created successfully with ID: {}", saved.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PostMapping("/addAll")
	@Operation(summary = "Add multiple students")
	public ResponseEntity<List<Student>> saveAllStudents(@Valid @RequestBody List<@Valid StudentDTO> dtos) {
		log.info("Received request to add {} students", dtos.size());
		List<Student> students = dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
		List<Student> saved = studentService.saveAllStudents(students);
		log.info("{} students saved successfully", saved.size());
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping
	@Operation(summary = "Get all students")
	public ResponseEntity<List<Student>> getAll() {
		log.info("Received request to fetch all students");
		List<Student> list = studentService.getAllStudents();
		log.info("Returning {} students", list.size());
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get student by ID")
	public ResponseEntity<Student> getById(@PathVariable Long id) {
		log.info("Fetching student with ID: {}", id);
		Student student = studentService.getStudentById(id);
		if (student != null) {
			log.info("Student found: {}", student.getName());
			return ResponseEntity.ok(student);
		} else {
			log.warn("Student not found with ID: {}", id);
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update student by ID")
	public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
		log.info("Request to update student with ID: {}", id);
		Student updated = studentService.updateStudent(id, convertToEntity(dto));
		if (updated != null) {
			log.info("Student updated successfully: {}", updated.getId());
			return ResponseEntity.ok(updated);
		} else {
			log.warn("Student not found for update with ID: {}", id);
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete student by ID")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		log.info("Request to delete student with ID: {}", id);
		studentService.deleteStudent(id);
		log.info("Student deleted with ID: {}", id);
		return ResponseEntity.ok("Student deleted");
	}

	private Student convertToEntity(StudentDTO dto) {
		return new Student(dto.getId(), dto.getName(), dto.getGender(), dto.getAge(),
				dto.getCity(), dto.getEmail(), dto.getNumber(),
				dto.getCompany(), dto.getSalary(), dto.getCountry());
	}
}
