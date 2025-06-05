//package com.lalit.kumar.controller;
//
//import com.lalit.kumar.entity.Student;
//import com.lalit.kumar.service.StudentService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/students")
//public class StudentController {
//
//	@Autowired
//	private StudentService studentService;
//
//	@PostMapping("/addData")
//	public Student createStudent(@RequestBody Student student) {
//		return studentService.saveStudent(student);
//	}
//
//	@PostMapping("/addAll")
//	public List<Student> saveAllStudents(@RequestBody List<Student> students) {
//		return studentService.saveAllStudents(students);
//	}
//
//	@GetMapping("/getData")
//	public List<Student> getAllStudents() {
//		return studentService.getAllStudents();
//	}
//
//	@GetMapping("/{id}")
//	public Student getStudentById(@PathVariable Long id) {
//		return studentService.getStudentById(id);
//	}
//
//	@PutMapping("/{id}")
//	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//		return studentService.updateStudent(id, student);
//	}
//
//	@DeleteMapping("/{id}")
//	public String deleteStudent(@PathVariable Long id) {
//		studentService.deleteStudent(id);
//		return "Student deleted successfully.";
//	}
//}

//-----------------------------------------------------
//package com.lalit.kumar.controller;
//
//import com.lalit.kumar.entity.Student;
//import com.lalit.kumar.service.StudentService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/students")
//@Tag(name = "Student", description = "CRUD operations for managing students")
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @Operation(summary = "Add a single student")
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Student successfully created"),
//        @ApiResponse(responseCode = "400", description = "Invalid request body")
//    })
//    @PostMapping("/addData")
//    public Student createStudent(@RequestBody Student student) {
//        return studentService.saveStudent(student);
//    }
//
//    @Operation(summary = "Add a list of students")
//    @PostMapping("/addAll")
//    public List<Student> saveAllStudents(@RequestBody List<Student> students) {
//        return studentService.saveAllStudents(students);
//    }
//
//    @Operation(summary = "Fetch all students")
//    @GetMapping("/getData")
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//
//    @Operation(summary = "Fetch student by ID")
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Student found"),
//        @ApiResponse(responseCode = "404", description = "Student not found")
//    })
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.getStudentById(id);
//    }
//
//    @Operation(summary = "Update student by ID")
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        return studentService.updateStudent(id, student);
//    }
//
//    @Operation(summary = "Delete student by ID")
//    @DeleteMapping("/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return "Student deleted successfully.";
//    }
//}

//------------------------------------------------------------
package com.lalit.kumar.controller;

import com.lalit.kumar.entity.Student;
import com.lalit.kumar.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student", description = "CRUD operations for managing students")
public class StudentController {

	private static final Logger logger = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@Operation(summary = "Add a single student")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student successfully created"),
			@ApiResponse(responseCode = "400", description = "Invalid request body") })
	@PostMapping("/addData")
	public Student createStudent(@RequestBody Student student) {
		logger.info("Received request to create student: {}", student.getName());
		Student savedStudent = studentService.saveStudent(student);
		logger.info("Student created with ID: {}", savedStudent.getId());
		return savedStudent;
	}

	@Operation(summary = "Add a list of students")
	@PostMapping("/addAll")
	public List<Student> saveAllStudents(@RequestBody List<Student> students) {
		logger.info("Received request to create multiple students, count: {}", students.size());
		List<Student> savedStudents = studentService.saveAllStudents(students);
		logger.info("Saved {} students successfully", savedStudents.size());
		return savedStudents;
	}

	@Operation(summary = "Fetch all students")
	@GetMapping("/getData")
	public List<Student> getAllStudents() {
		logger.info("Received request to fetch all students");
		List<Student> students = studentService.getAllStudents();
		logger.info("Fetched {} students", students.size());
		return students;
	}

	@Operation(summary = "Fetch student by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student found"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		logger.info("Received request to fetch student with ID: {}", id);
		Student student = studentService.getStudentById(id);
		if (student == null) {
			logger.warn("Student with ID {} not found", id);
		} else {
			logger.info("Student found: {}", student.getName());
		}
		return student;
	}

	@Operation(summary = "Update student by ID")
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		logger.info("Received request to update student with ID: {}", id);
		Student updatedStudent = studentService.updateStudent(id, student);
		if (updatedStudent == null) {
			logger.warn("Student with ID {} not found for update", id);
		} else {
			logger.info("Student updated with ID: {}", id);
		}
		return updatedStudent;
	}

	@Operation(summary = "Delete student by ID")
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		logger.info("Received request to delete student with ID: {}", id);
		studentService.deleteStudent(id);
		logger.info("Student deleted with ID: {}", id);
		return "Student deleted successfully.";
	}
}
