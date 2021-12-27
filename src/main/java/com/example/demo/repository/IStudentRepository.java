package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Long> {
}
