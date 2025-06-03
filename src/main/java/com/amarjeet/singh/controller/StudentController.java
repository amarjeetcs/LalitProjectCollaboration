package com.amarjeet.singh.controller;

import com.amarjeet.singh.entity.Student;
import com.amarjeet.singh.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addData")
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@PostMapping("/addAll")
	public List<Student> saveAllStudents(@RequestBody List<Student> students) {
		return studentService.saveAllStudents(students);
	}

	@GetMapping("/getData")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "Student deleted successfully.";
	}
}
