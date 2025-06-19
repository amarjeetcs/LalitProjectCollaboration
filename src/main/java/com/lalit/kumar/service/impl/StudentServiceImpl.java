package com.lalit.kumar.service.impl;

import com.lalit.kumar.entity.Student;
import com.lalit.kumar.exception.DuplicateFieldException;
import com.lalit.kumar.repository.StudentRepository;
import com.lalit.kumar.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@Log4j2
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		log.info("Attempting to save student: {}", student);

		if (studentRepository.existsByEmail(student.getEmail())) {
			log.warn("Duplicate email found: {}", student.getEmail());
			throw new DuplicateFieldException("Email already exists: " + student.getEmail());
		}

		if (studentRepository.existsByNumber(student.getNumber())) {
			log.warn("Duplicate phone number found: {}", student.getNumber());
			throw new DuplicateFieldException("Phone number already exists: " + student.getNumber());
		}

		Student saved = studentRepository.save(student);
		log.info("Student saved successfully with ID: {}", saved.getId());
		return saved;
	}

	@Override
	public List<Student> saveAllStudents(List<Student> students) {
		log.info("Attempting to save a list of {} students", students.size());

		for (Student student : students) {
			if (studentRepository.existsByEmail(student.getEmail())) {
				log.warn("Duplicate email found in batch: {}", student.getEmail());
				throw new DuplicateFieldException("Email already exists: " + student.getEmail());
			}
			if (studentRepository.existsByNumber(student.getNumber())) {
				log.warn("Duplicate phone number found in batch: {}", student.getNumber());
				throw new DuplicateFieldException("Phone number already exists: " + student.getNumber());
			}
		}

		List<Student> savedList = studentRepository.saveAll(students);
		log.info("{} students saved successfully", savedList.size());
		return savedList;
	}

	@Override
	public List<Student> getAllStudents() {
		log.info("Fetching all students from database");
		List<Student> list = studentRepository.findAll();
		log.info("Total students retrieved: {}", list.size());
		return list;
	}

	@Override
	public Student getStudentById(Long id) {
		log.info("Fetching student by ID: {}", id);
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Long id, Student updatedStudent) {
		log.info("Attempting to update student with ID: {}", id);

		Student student = getStudentById(id);
		if (student == null) {
			log.warn("Student not found with ID: {}", id);
			return null;
		}

		if (!student.getEmail().equals(updatedStudent.getEmail()) &&
				studentRepository.existsByEmail(updatedStudent.getEmail())) {
			log.warn("Duplicate email detected during update: {}", updatedStudent.getEmail());
			throw new DuplicateFieldException("Email already exists: " + updatedStudent.getEmail());
		}

		if (!student.getNumber().equals(updatedStudent.getNumber()) &&
				studentRepository.existsByNumber(updatedStudent.getNumber())) {
			log.warn("Duplicate phone number detected during update: {}", updatedStudent.getNumber());
			throw new DuplicateFieldException("Phone number already exists: " + updatedStudent.getNumber());
		}

		student.setName(updatedStudent.getName());
		student.setGender(updatedStudent.getGender());
		student.setAge(updatedStudent.getAge());
		student.setCity(updatedStudent.getCity());
		student.setEmail(updatedStudent.getEmail());
		student.setNumber(updatedStudent.getNumber());
		student.setCompany(updatedStudent.getCompany());
		student.setSalary(updatedStudent.getSalary());
		student.setCountry(updatedStudent.getCountry());

		Student saved = studentRepository.save(student);
		log.info("Student updated successfully with ID: {}", saved.getId());
		return saved;
	}

	@Override
	public void deleteStudent(Long id) {
		log.info("Deleting student with ID: {}", id);
		studentRepository.deleteById(id);
		log.info("Student deleted successfully with ID: {}", id);
	}

	@Override
	public Page<Student> getStudentsWithPagination(int page, int size) {
		log.info("Fetching students with pagination - Page: {}, Size: {}", page, size);
		Pageable pageable = PageRequest.of(page, size);
		return studentRepository.findAll(pageable);
	}

}
