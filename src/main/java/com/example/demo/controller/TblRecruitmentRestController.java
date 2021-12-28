package com.example.demo.controller;

import com.example.demo.model.TblRecruitment;
import com.example.demo.service.ITblRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("/tblRecruitments")
@CrossOrigin("*")
public class TblRecruitmentRestController {

    @Autowired
    private ITblRecruitmentService tblRecruitmentService;

    @GetMapping
    public ResponseEntity<Page<TblRecruitment>> findAll(
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TblRecruitment> tblRecruitments = tblRecruitmentService.findAll(pageable);
        return new ResponseEntity<>(tblRecruitments, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TblRecruitment> findById(@PathVariable Long id) {
        Optional<TblRecruitment> tblRecruitmentOptional = tblRecruitmentService.findById(id);
        if (tblRecruitmentOptional.isPresent()) {
            return new ResponseEntity<>(tblRecruitmentOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TblRecruitment> save(@RequestBody TblRecruitment tblRecruitment) {
        Timestamp createAt = new Timestamp(System.currentTimeMillis());
        tblRecruitment.setCreateAt(createAt);
        return new ResponseEntity<>(tblRecruitmentService.save(tblRecruitment), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TblRecruitment> edit(@PathVariable Long id, @RequestBody TblRecruitment tblRecruitment) {
        Optional<TblRecruitment> tblRecruitmentOptional = tblRecruitmentService.findById(id);
        if (tblRecruitmentOptional.isPresent()) {
            TblRecruitment oldTblRecruitment = tblRecruitmentOptional.get();
            tblRecruitment.setId(oldTblRecruitment.getId());
            Timestamp updateAt = new Timestamp(System.currentTimeMillis());
            tblRecruitment.setUpdateAt(updateAt);
            return new ResponseEntity<>(tblRecruitmentService.save(oldTblRecruitment), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TblRecruitment> delete(@PathVariable Long id) {
        Optional<TblRecruitment> tblRecruitmentOptional = tblRecruitmentService.findById(id);
        if (tblRecruitmentOptional.isPresent()) {
            tblRecruitmentService.deleteById(id);
            return new ResponseEntity<>(tblRecruitmentOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
