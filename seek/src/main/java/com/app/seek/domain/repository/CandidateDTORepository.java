package com.app.seek.domain.repository;

import com.app.seek.domain.dto.CandidateDTO;

import java.util.List;
import java.util.Optional;

public interface CandidateDTORepository {

    List<CandidateDTO> getCandidates();
    Optional<CandidateDTO> getCandidate(int candidateId);
    CandidateDTO saveCandidate(CandidateDTO candidate);
    void deleteCandidate(int candidateId);

}
