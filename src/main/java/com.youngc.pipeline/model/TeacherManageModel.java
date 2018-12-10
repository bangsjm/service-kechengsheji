package com.youngc.pipeline.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherManageModel {
    private String teacherNumber;

    private String password;

    private String email;

    private String teacherName;

    private String sex;

    private String selectmajor;

    private String prof;

    private String hiredate;

    private String selectcollege;

    private String otherteacherNumber;
}
