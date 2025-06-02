package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// Create student - POST /api/students
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	// Get all students - GET /api/students
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	// Get student by ID - GET /api/students/{id}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	// Update student by ID - PUT /api/students/{id}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	// Delete student by ID - DELETE /api/students/{id}
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "Student deleted successfully.";
	}
}
