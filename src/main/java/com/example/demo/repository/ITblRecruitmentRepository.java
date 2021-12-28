package com.example.demo.repository;

import com.example.demo.model.TblRecruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITblRecruitmentRepository extends JpaRepository<TblRecruitment, Long> {
}
