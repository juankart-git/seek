package com.app.seek.persistence.mapper;

import com.app.seek.domain.dto.CandidateDTO;
import com.app.seek.persistence.entity.Candidate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper( CandidateMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "salary_expected", target = "salary_expected"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "document_number", target = "document_number"),
            @Mapping(source = "birthday", target = "birthday")
    })
    CandidateDTO toCandidateDTO(Candidate candidate);


    List<CandidateDTO> toCandidates(List<Candidate> candidates);

    @InheritInverseConfiguration
    Candidate toCandidate(CandidateDTO candidate);

}
