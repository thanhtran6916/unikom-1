package com.example.demo.repository;

import com.example.demo.model.TblRecruitment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITblRecruitmentRepository extends JpaRepository<TblRecruitment, Long> {

    @Query(value = "SELECT t FROM TblRecruitment t WHERE t.isDeleted = false ")
    Page<TblRecruitment> findTblRecruitmentsExist(Pageable pageable);

}
