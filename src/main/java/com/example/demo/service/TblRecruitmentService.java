package com.example.demo.service;

import com.example.demo.model.TblRecruitment;
import com.example.demo.repository.ITblRecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TblRecruitmentService implements ITblRecruitmentService {

    @Autowired
    private ITblRecruitmentRepository tblRecruitmentRepository;

    @Override
    public Page<TblRecruitment> findAll(Pageable pageable) {
        return tblRecruitmentRepository.findAll(pageable);
    }

    @Override
    public Iterable<TblRecruitment> findAll() {
        return tblRecruitmentRepository.findAll();
    }

    @Override
    public Optional<TblRecruitment> findById(Long id) {
        return tblRecruitmentRepository.findById(id);
    }

    @Override
    public TblRecruitment save(TblRecruitment tblRecruitment) {
        return tblRecruitmentRepository.save(tblRecruitment);
    }

    @Override
    public void deleteById(Long id) {
        tblRecruitmentRepository.deleteById(id);
    }
}
