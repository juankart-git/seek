package com.app.seek.domain.service;

import com.app.seek.domain.dto.CandidateDTO;
import com.app.seek.domain.repository.CandidateDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateDTORepository repository;

    public List<CandidateDTO> getCandidates(){
        return repository.getCandidates();
    }

    public Optional<CandidateDTO> getCandidate(int id){
        return repository.getCandidate(id);
    }

    public CandidateDTO saveCandidate(CandidateDTO candidate){
        return repository.saveCandidate(candidate);
    }

    public boolean deleteCandidate(int id){
        return getCandidate(id).map(prod -> {
            repository.deleteCandidate(id);
            return true;
        }).orElse(false);
    }

}
