package com.example.demo.service.tblRecruitment;

import com.example.demo.exception.NotFoundException;
import com.example.demo.helper.CustomExceptionHandler;
import com.example.demo.model.TblRecruitment;
import com.example.demo.model.User;
import com.example.demo.repository.ITblRecruitmentRepository;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class TblRecruitmentService implements ITblRecruitmentService {

    @Autowired
    private ITblRecruitmentRepository tblRecruitmentRepository;

    @Autowired
    private IUserService userService;

    @Override
    public Page<TblRecruitment> findTblRecruitmentsExist(Pageable pageable) {
        Page<TblRecruitment> tblRecruitments = tblRecruitmentRepository.findTblRecruitmentsExist(pageable);
        if (tblRecruitments == null) {
            throw new NotFoundException("Not found entity");
        }
        return tblRecruitments;
    }

    @Override
    public Iterable<TblRecruitment> findAll() {
        Iterable<TblRecruitment> tblRecruitments = tblRecruitmentRepository.findAll();
        if (tblRecruitments == null) {
            throw new NotFoundException("Not found entity");
        }
        return tblRecruitments;
    }

    @Override
    public Optional<TblRecruitment> findById(Long id) {
        Optional<TblRecruitment> tblRecruitmentOptional = tblRecruitmentRepository.findById(id);
        if (!tblRecruitmentOptional.isPresent()) {
            throw new NotFoundException(NotFoundException.ID_NOT_FOUND);
        }
        return tblRecruitmentRepository.findById(id);
    }

    @Override
    public TblRecruitment save(TblRecruitment tblRecruitment) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        if (tblRecruitment.getId() != null) {
            Timestamp updateAt = new Timestamp(System.currentTimeMillis());
//            tblRecruitment.setUpdateAt(updateAt);
//            tblRecruitment.setUpdateBy(user.getId().toString());
            return tblRecruitmentRepository.save(tblRecruitment);
        }
        Timestamp createAt = new Timestamp(System.currentTimeMillis());
//        tblRecruitment.setCreateAt(createAt);
        tblRecruitment.setCreateBy(user.getId().toString());
//        tblRecruitment.setIsDeleted(false);
        return tblRecruitmentRepository.save(tblRecruitment);
    }

    @Override
    public boolean delete(Long id) {
        Optional<TblRecruitment> tblRecruitmentOptional = tblRecruitmentRepository.findById(id);
        if (!tblRecruitmentOptional.isPresent()) {
            throw new NotFoundException(NotFoundException.ID_NOT_FOUND);
        }
        TblRecruitment tblRecruitment = tblRecruitmentOptional.get();
//        tblRecruitment.setIsDeleted(true);
        tblRecruitmentRepository.save(tblRecruitment);
        return true;
    }
}
