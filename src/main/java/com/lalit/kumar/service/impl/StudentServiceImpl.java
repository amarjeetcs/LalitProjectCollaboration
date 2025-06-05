package com.lalit.kumar.service.impl;

import com.lalit.kumar.entity.Student;
import com.lalit.kumar.repository.StudentRepository;
import com.lalit.kumar.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> saveAllStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

//	@Override
//	public Student updateStudent(Long id, Student updatedStudent) {
//		Student student = getStudentById(id);
//		if (student != null) {
//			student.setName(updatedStudent.getName());
//			student.setCity(updatedStudent.getCity());
//			student.setNumber(updatedStudent.getNumber());
//			student.setEmail(updatedStudent.getEmail());
//			return studentRepository.save(student);
//		}
//		return null;
//	}
	@Override
	public Student updateStudent(Long id, Student updatedStudent) {
	    Student student = getStudentById(id);
	    if (student != null) {
	        student.setName(updatedStudent.getName());
	        student.setGender(updatedStudent.getGender());
	        student.setAge(updatedStudent.getAge());
	        student.setCity(updatedStudent.getCity());
	        student.setEmail(updatedStudent.getEmail());
	        student.setNumber(updatedStudent.getNumber());
	        student.setCompany(updatedStudent.getCompany());
	        student.setSalary(updatedStudent.getSalary());
	        student.setCountry(updatedStudent.getCountry());
	        return studentRepository.save(student);
	    }
	    return null;
	}


	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
