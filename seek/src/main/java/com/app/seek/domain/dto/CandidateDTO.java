package com.app.seek.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
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
