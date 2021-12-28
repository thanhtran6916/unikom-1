package com.example.demo.service;

import com.example.demo.model.TblRecruitment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService {
    Page<TblRecruitment> findAll(Pageable pageable);

    Optional<TblRecruitment> findById(Long id);

    TblRecruitment save(TblRecruitment tblRecruitment);

    void deleteById(Long id);
}
