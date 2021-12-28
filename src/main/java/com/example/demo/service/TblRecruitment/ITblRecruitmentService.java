package com.example.demo.service.TblRecruitment;

import com.example.demo.model.TblRecruitment;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITblRecruitmentService extends IGeneralService<TblRecruitment> {

    Page<TblRecruitment> findTblRecruitmentsExist(Pageable pageable);
}
