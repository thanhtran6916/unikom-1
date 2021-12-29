package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class TblRecruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int", length = 11, nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "responsibility", columnDefinition = "text")
    private String responsibility;

    @Column(name = "benefit", columnDefinition = "text")
    private String benefit;

    @Column(name = "experience",columnDefinition = "text")
    private String experience;

    @Column(name = "skill",columnDefinition = "text")
    private String skill;

    @Column(name = "attitude",columnDefinition = "text")
    private String attitude;

    @Column(name = "expireDate")
    private LocalDate expireDate;

    @Column(name = "salary")
    private String salary;

    @Column(name = "is_delete")
    private boolean isDeleted;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_by")
    private String updateBy;
}
