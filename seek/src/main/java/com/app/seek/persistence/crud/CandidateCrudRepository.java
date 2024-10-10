package com.app.seek.persistence.crud;

import com.app.seek.persistence.entity.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateCrudRepository extends CrudRepository<Candidate, Integer> {

}
