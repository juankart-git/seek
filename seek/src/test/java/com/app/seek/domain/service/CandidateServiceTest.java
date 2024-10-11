package com.app.seek.domain.service;

import com.app.seek.domain.dto.CandidateDTO;
import com.app.seek.domain.repository.CandidateDTORepository;
import com.app.seek.persistence.crud.CandidateCrudRepository;
import com.app.seek.persistence.entity.Candidate;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CandidateServiceTest {



    @InjectMocks
    private CandidateService service;

    @Mock
    private CandidateDTORepository repository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void service_Create_ReturnsDto() {
        CandidateDTO candidateDTO = CandidateDTO.builder()
                .name("Pepito2")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        when(repository.saveCandidate(Mockito.any(CandidateDTO.class))).thenReturn(candidateDTO);
        CandidateDTO savedCandidate = service.saveCandidate(candidateDTO);
        Assertions.assertThat(savedCandidate).isNotNull();
    }

    @Test
    public void service_DeleteById_ReturnVoid() {
        int candidateId = 1;
        CandidateDTO candidate = CandidateDTO.builder()
                .name("Pepito2")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        when(repository.getCandidate(candidateId)).thenReturn(Optional.ofNullable(candidate));
        doNothing().when(repository).deleteCandidate(candidateId);
        assertAll(() -> service.deleteCandidate(candidateId));
    }

}