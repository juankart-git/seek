package com.app.seek.web.controller;

import com.app.seek.domain.dto.CandidateDTO;
import com.app.seek.domain.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping("/all")
    public ResponseEntity<List<CandidateDTO>> findAll(){
        return ResponseEntity.ok(service.getCandidates());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CandidateDTO> getProduct(@PathVariable("id") int id){
        return service.getCandidate(id)
                .map(prod -> ResponseEntity.ok(prod))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CandidateDTO> save(@RequestBody CandidateDTO candidate){
        return new ResponseEntity<>(service.saveCandidate(candidate), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if(service.deleteCandidate(id)){
            return (ResponseEntity) ResponseEntity.ok();
        }else{
            return (ResponseEntity) ResponseEntity.notFound();
        }
    }
}
