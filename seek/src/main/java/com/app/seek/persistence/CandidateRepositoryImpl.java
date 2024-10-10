package com.app.seek.persistence;

import com.app.seek.domain.dto.CandidateDTO;
import com.app.seek.domain.repository.CandidateDTORepository;
import com.app.seek.persistence.crud.CandidateCrudRepository;
import com.app.seek.persistence.entity.Candidate;
import com.app.seek.persistence.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CandidateRepositoryImpl implements CandidateDTORepository {

    @Autowired
    private CandidateCrudRepository repository;

    @Autowired
    private CandidateMapper mapper;

    @Override
    public List<CandidateDTO> getCandidates() {

        List<Candidate> candidate = (List<Candidate>) repository.findAll();
        return mapper.toCandidates(candidate);
    }

    @Override
    public Optional<CandidateDTO> getCandidate(int candidateId) {
        return repository.findById(candidateId).map(cand -> mapper.toCandidateDTO(cand));
    }

    @Override
    public CandidateDTO saveCandidate(CandidateDTO candidate) {
        return mapper.toCandidateDTO(repository.save(mapper.toCandidate(candidate)));
    }

    @Override
    public void deleteCandidate(int candidateId) {
        repository.deleteById(candidateId);
    }
}
