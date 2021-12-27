package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.Optional;

public interface IGeneralService {
    Iterable<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
}
