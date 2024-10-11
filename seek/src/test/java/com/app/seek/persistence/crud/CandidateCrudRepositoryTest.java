package com.app.seek.persistence.crud;

import com.app.seek.persistence.entity.Candidate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CandidateCrudRepositoryTest {

    @Autowired
    private CandidateCrudRepository candidateCrudRepository;

    @Test
    public void saveAll_returnedSaved() {
        Candidate candidate = Candidate.builder()
                .name("Pepito")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        Candidate savedCandidate = candidateCrudRepository.save(candidate);
        Assertions.assertThat(savedCandidate).isNotNull();
        Assertions.assertThat(savedCandidate.getId()).isGreaterThan(0);
    }

    @Test
    public void repository_GetAll_ReturnMoreThenOne() {
        Candidate candidate = Candidate.builder()
                .name("Pepito")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        Candidate candidate2 = Candidate.builder()
                .name("Pepito2")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        candidateCrudRepository.save(candidate);
        candidateCrudRepository.save(candidate2);
        List<Candidate> candidateList = (List<Candidate>) candidateCrudRepository.findAll();
        Assertions.assertThat(candidateList).isNotNull();
        Assertions.assertThat(candidateList.size()).isGreaterThan(0);
    }

    @Test
    public void repository_FindById_ReturnCandidate() {
        Candidate candidate = Candidate.builder()
                .name("Pepito2")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        candidateCrudRepository.save(candidate);
        Candidate pokemonList = candidateCrudRepository.findById(candidate.getId()).get();
        Assertions.assertThat(pokemonList).isNotNull();
    }

    @Test
    public void PokemonRepository_PokemonDelete_ReturnPokemonIsEmpty() {
        Candidate candidate = Candidate.builder()
                .name("Pepito2")
                .birthday(new Date(System.currentTimeMillis()))
                .document_number(12345)
                .email("email@email.com")
                .gender("M")
                .phone("3000000000")
                .salary_expected(20000)
                .build();

        candidateCrudRepository.save(candidate);
        candidateCrudRepository.deleteById(candidate.getId());
        Optional<Candidate> candidateReturn = candidateCrudRepository.findById(candidate.getId());
        Assertions.assertThat(candidateReturn).isEmpty();
    }


}