package com.example.demo.service;

import com.example.demo.model.TblRecruitment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITblRecruitmentService extends IGeneralService<TblRecruitment> {

    Page<TblRecruitment> findAll(Pageable pageable);
}
