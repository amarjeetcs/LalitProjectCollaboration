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
//package com.lalit.kumar.controller;
//
//import com.lalit.kumar.entity.Student;
//import com.lalit.kumar.service.StudentService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
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
//	private static final Logger logger = LogManager.getLogger(StudentController.class);
//
//	@Autowired
//	private StudentService studentService;
//
//	@Operation(summary = "Add a single student")
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student successfully created"),
//			@ApiResponse(responseCode = "400", description = "Invalid request body") })
//	@PostMapping("/addData")
//	public Student createStudent(@RequestBody Student student) {
//		logger.info("Received request to create student: {}", student.getName());
//		Student savedStudent = studentService.saveStudent(student);
//		logger.info("Student created with ID: {}", savedStudent.getId());
//		return savedStudent;
//	}
//
//	@Operation(summary = "Add a list of students")
//	@PostMapping("/addAll")
//	public List<Student> saveAllStudents(@RequestBody List<Student> students) {
//		logger.info("Received request to create multiple students, count: {}", students.size());
//		List<Student> savedStudents = studentService.saveAllStudents(students);
//		logger.info("Saved {} students successfully", savedStudents.size());
//		return savedStudents;
//	}
//
//	@Operation(summary = "Fetch all students")
//	@GetMapping("/getData")
//	public List<Student> getAllStudents() {
//		logger.info("Received request to fetch all students");
//		List<Student> students = studentService.getAllStudents();
//		logger.info("Fetched {} students", students.size());
//		return students;
//	}
//
//	@Operation(summary = "Fetch student by ID")
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student found"),
//			@ApiResponse(responseCode = "404", description = "Student not found") })
//	@GetMapping("/{id}")
//	public Student getStudentById(@PathVariable Long id) {
//		logger.info("Received request to fetch student with ID: {}", id);
//		Student student = studentService.getStudentById(id);
//		if (student == null) {
//			logger.warn("Student with ID {} not found", id);
//		} else {
//			logger.info("Student found: {}", student.getName());
//		}
//		return student;
//	}
//
//	@Operation(summary = "Update student by ID")
//	@PutMapping("/{id}")
//	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//		logger.info("Received request to update student with ID: {}", id);
//		Student updatedStudent = studentService.updateStudent(id, student);
//		if (updatedStudent == null) {
//			logger.warn("Student with ID {} not found for update", id);
//		} else {
//			logger.info("Student updated with ID: {}", id);
//		}
//		return updatedStudent;
//	}
//
//	@Operation(summary = "Delete student by ID")
//	@DeleteMapping("/{id}")
//	public String deleteStudent(@PathVariable Long id) {
//		logger.info("Received request to delete student with ID: {}", id);
//		studentService.deleteStudent(id);
//		logger.info("Student deleted with ID: {}", id);
//		return "Student deleted successfully.";
//	}
//}

//---------------------------above code without using validation api and below code with using validation api
//package com.lalit.kumar.controller;
//
//import com.lalit.kumar.dto.StudentDTO;
//import com.lalit.kumar.entity.Student;
//import com.lalit.kumar.service.StudentService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/students")
//@Tag(name = "Student", description = "CRUD operations for managing students")
//@Validated
//public class StudentController {
//
//	private static final Logger logger = LogManager.getLogger(StudentController.class);
//
//	@Autowired
//	private StudentService studentService;
//
//	@Operation(summary = "Add a single student")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Student successfully created"),
//			@ApiResponse(responseCode = "400", description = "Invalid request body")
//	})
//	@PostMapping("/addData")
//	public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) {
//		logger.info("Received request to create student: {}", studentDTO.getName());
//		Student student = convertToEntity(studentDTO);
//		Student savedStudent = studentService.saveStudent(student);
//		logger.info("Student created with ID: {}", savedStudent.getId());
//		return savedStudent;
//	}
//
//	@Operation(summary = "Add a list of students")
//	@PostMapping("/addAll")
//	public List<Student> saveAllStudents(@Valid @RequestBody List<StudentDTO> studentDTOs) {
//		logger.info("Received request to create multiple students, count: {}", studentDTOs.size());
//		List<Student> students = studentDTOs.stream().map(this::convertToEntity).collect(Collectors.toList());
//		List<Student> savedStudents = studentService.saveAllStudents(students);
//		logger.info("Saved {} students successfully", savedStudents.size());
//		return savedStudents;
//	}
//
//	@Operation(summary = "Fetch all students")
//	@GetMapping("/getData")
//	public List<Student> getAllStudents() {
//		logger.info("Received request to fetch all students");
//		List<Student> students = studentService.getAllStudents();
//		logger.info("Fetched {} students", students.size());
//		return students;
//	}
//
//	@Operation(summary = "Fetch student by ID")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Student found"),
//			@ApiResponse(responseCode = "404", description = "Student not found")
//	})
//	@GetMapping("/{id}")
//	public Student getStudentById(@PathVariable Long id) {
//		logger.info("Received request to fetch student with ID: {}", id);
//		Student student = studentService.getStudentById(id);
//		if (student == null) {
//			logger.warn("Student with ID {} not found", id);
//		} else {
//			logger.info("Student found: {}", student.getName());
//		}
//		return student;
//	}
//
//	@Operation(summary = "Update student by ID")
//	@PutMapping("/{id}")
//	public Student updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO studentDTO) {
//		logger.info("Received request to update student with ID: {}", id);
//		Student student = convertToEntity(studentDTO);
//		Student updatedStudent = studentService.updateStudent(id, student);
//		if (updatedStudent == null) {
//			logger.warn("Student with ID {} not found for update", id);
//		} else {
//			logger.info("Student updated with ID: {}", id);
//		}
//		return updatedStudent;
//	}
//
//	@Operation(summary = "Delete student by ID")
//	@DeleteMapping("/{id}")
//	public String deleteStudent(@PathVariable Long id) {
//		logger.info("Received request to delete student with ID: {}", id);
//		studentService.deleteStudent(id);
//		logger.info("Student deleted with ID: {}", id);
//		return "Student deleted successfully.";
//	}
//
//	// ✅ Utility method to convert DTO → Entity
//	private Student convertToEntity(StudentDTO dto) {
//		Student student = new Student();
//		student.setName(dto.getName());
//		student.setGender(dto.getGender());
//		student.setAge(dto.getAge());
//		student.setCity(dto.getCity());
//		student.setEmail(dto.getEmail());
//		student.setNumber(dto.getNumber());
//		student.setCompany(dto.getCompany());
//		student.setSalary(dto.getSalary());
//		student.setCountry(dto.getCountry());
//		return student;
//	}
//}
//===============================================above code without using ResponseEntity and below code using ResponseEntity
//package com.lalit.kumar.controller;
//
//import com.lalit.kumar.dto.StudentDTO;
//import com.lalit.kumar.entity.Student;
//import com.lalit.kumar.service.StudentService;
//import io.swagger.v3.oas.annotations.*;
//import io.swagger.v3.oas.annotations.responses.*;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/students")
//@Validated  // ✅ Required for method-level validation
//@Tag(name = "Student", description = "CRUD operations for managing students")
//@Log4j2
//public class StudentController {
//
//	@Autowired
//	private StudentService studentService;
//
//	@PostMapping("/addData")
//	@Operation(summary = "Add a single student")
//	@ApiResponses({
//			@ApiResponse(responseCode = "201", description = "Student created"),
//			@ApiResponse(responseCode = "400", description = "Validation failed")
//	})
//	public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO dto) {
//		log.info("Creating student: {}", dto.getName());
//		Student student = convertToEntity(dto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
//	}
//
//	@PostMapping("/addAll")
//	@Operation(summary = "Add multiple students")
//	public ResponseEntity<List<Student>> saveAllStudents(@Valid @RequestBody List<@Valid StudentDTO> dtos) {
//		log.info("Creating {} students", dtos.size());
//		List<Student> students = dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
//		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveAllStudents(students));
//	}
//
//	@GetMapping
//	@Operation(summary = "Get all students")
//	public ResponseEntity<List<Student>> getAll() {
//		return ResponseEntity.ok(studentService.getAllStudents());
//	}
//
//	@GetMapping("/{id}")
//	@Operation(summary = "Get student by ID")
//	public ResponseEntity<Student> getById(@PathVariable Long id) {
//		Student student = studentService.getStudentById(id);
//		return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
//	}
//
//	@PutMapping("/{id}")
//	@Operation(summary = "Update student by ID")
//	public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
//		Student updated = studentService.updateStudent(id, convertToEntity(dto));
//		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
//	}
//
//	@DeleteMapping("/{id}")
//	@Operation(summary = "Delete student by ID")
//	public ResponseEntity<String> delete(@PathVariable Long id) {
//		studentService.deleteStudent(id);
//		return ResponseEntity.ok("Student deleted");
//	}
//
//	private Student convertToEntity(StudentDTO dto) {
//		return new Student(dto.getId(), dto.getName(), dto.getGender(), dto.getAge(),
//				dto.getCity(), dto.getEmail(), dto.getNumber(),
//				dto.getCompany(), dto.getSalary(), dto.getCountry());
//	}
//}
//================================with loggin in better way

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
@Validated  // ✅ Required for method-level validation
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
