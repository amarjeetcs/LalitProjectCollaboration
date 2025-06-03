package com.amarjeet.singh.service;

import java.util.List;

import com.amarjeet.singh.entity.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> saveAllStudents(List<Student> students);
	List<Student> getAllStudents();
	Student getStudentById(Long id);
	Student updateStudent(Long id, Student updatedStudent);
	void deleteStudent(Long id);
}
