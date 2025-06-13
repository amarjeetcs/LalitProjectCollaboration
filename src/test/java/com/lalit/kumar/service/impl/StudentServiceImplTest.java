package com.lalit.kumar.service.impl;

import com.lalit.kumar.entity.Student;
import com.lalit.kumar.exception.DuplicateFieldException;
import com.lalit.kumar.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        student = new Student(1L, "John", "Male", 22, "Delhi", "john@email.com",
                "9876543210", "ABC Corp", 30000.0, "India");
    }

    @Test
    void testSaveStudent_Success() {
        when(studentRepository.existsByEmail(student.getEmail())).thenReturn(false);
        when(studentRepository.existsByNumber(student.getNumber())).thenReturn(false);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student saved = studentService.saveStudent(student);

        assertEquals(student.getEmail(), saved.getEmail());
        verify(studentRepository).save(student);
    }

    @Test
    void testSaveStudent_DuplicateEmail() {
        when(studentRepository.existsByEmail(student.getEmail())).thenReturn(true);

        assertThrows(DuplicateFieldException.class, () -> studentService.saveStudent(student));
    }

    @Test
    void testSaveStudent_DuplicateNumber() {
        when(studentRepository.existsByEmail(student.getEmail())).thenReturn(false);
        when(studentRepository.existsByNumber(student.getNumber())).thenReturn(true);

        assertThrows(DuplicateFieldException.class, () -> studentService.saveStudent(student));
    }

    @Test
    void testSaveAllStudents_Success() {
        List<Student> students = List.of(student);
        when(studentRepository.existsByEmail(anyString())).thenReturn(false);
        when(studentRepository.existsByNumber(anyString())).thenReturn(false);
        when(studentRepository.saveAll(anyList())).thenReturn(students);

        List<Student> saved = studentService.saveAllStudents(students);

        assertEquals(1, saved.size());
    }

    @Test
    void testSaveAllStudents_DuplicateEmail() {
        when(studentRepository.existsByEmail(anyString())).thenReturn(true);

        List<Student> students = List.of(student);
        assertThrows(DuplicateFieldException.class, () -> studentService.saveAllStudents(students));
    }

    @Test
    void testGetAllStudents() {
        List<Student> expectedList = List.of(student);
        when(studentRepository.findAll()).thenReturn(expectedList);

        List<Student> result = studentService.getAllStudents();

        assertEquals(1, result.size());
    }

    @Test
    void testGetStudentById_Found() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student found = studentService.getStudentById(1L);

        assertNotNull(found);
    }

    @Test
    void testGetStudentById_NotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        Student found = studentService.getStudentById(1L);

        assertNull(found);
    }

    @Test
    void testUpdateStudent_Success() {
        Student updatedData = new Student(1L, "Updated", "Male", 23, "Mumbai", "john@email.com", "9876543210", "XYZ Ltd", 40000.0, "India");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.existsByEmail(updatedData.getEmail())).thenReturn(false);
        when(studentRepository.existsByNumber(updatedData.getNumber())).thenReturn(false);
        when(studentRepository.save(any(Student.class))).thenReturn(updatedData);

        Student updated = studentService.updateStudent(1L, updatedData);

        assertEquals("Updated", updated.getName());
    }

    @Test
    void testUpdateStudent_NotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        Student result = studentService.updateStudent(1L, student);

        assertNull(result);
    }

    @Test
    void testUpdateStudent_DuplicateEmail() {
        Student updated = new Student(1L, "Test", "Male", 22, "Delhi", "new@email.com", "9876543210", "ABC Corp", 30000.0, "India");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.existsByEmail("new@email.com")).thenReturn(true);

        assertThrows(DuplicateFieldException.class, () -> studentService.updateStudent(1L, updated));
    }

    @Test
    void testUpdateStudent_DuplicateNumber() {
        Student updated = new Student(1L, "Test", "Male", 22, "Delhi", "john@email.com", "1234567890", "ABC Corp", 30000.0, "India");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.existsByNumber("1234567890")).thenReturn(true);

        assertThrows(DuplicateFieldException.class, () -> studentService.updateStudent(1L, updated));
    }

    @Test
    void testDeleteStudent() {
        studentService.deleteStudent(1L);
        verify(studentRepository).deleteById(1L);
    }
}
