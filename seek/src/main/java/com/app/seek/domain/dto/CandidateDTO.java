package com.app.seek.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private Integer salary_expected;
    private Date birthday;
    private String phone;
    private Integer document_number;
}
