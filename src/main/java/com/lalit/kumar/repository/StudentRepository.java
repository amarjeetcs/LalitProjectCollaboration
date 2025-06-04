package com.lalit.kumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lalit.kumar.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
