package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int", length = 11, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
