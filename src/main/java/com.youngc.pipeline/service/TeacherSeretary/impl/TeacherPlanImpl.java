package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.youngc.pipeline.mapper.TeacherSeretary.TeacherPlanMapper;
import com.youngc.pipeline.service.TeacherSeretary.TeacherPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherPlanImpl implements TeacherPlanService{

    @Autowired
    TeacherPlanMapper teacherPlanMapper;


}
