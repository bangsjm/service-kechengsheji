package com.youngc.pipeline.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentManagerModel {
    private String studentNumber;

    private String oldStudentNumber;

    private String password;

    private String email;

    private String studentName;

    private String sex;

    private Long entranceYear;

    private Long grade;
}
