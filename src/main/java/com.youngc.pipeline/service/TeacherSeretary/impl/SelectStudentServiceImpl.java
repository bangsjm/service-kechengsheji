package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.youngc.pipeline.mapper.TeacherSeretary.SelectStudentMapper;
import com.youngc.pipeline.model.College;
import com.youngc.pipeline.service.TeacherSeretary.SelectStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectStudentServiceImpl implements SelectStudentService {

    @Autowired
    private SelectStudentMapper selectStudentMapper;

    public List<College> selectCollege(){
        List<College> demo=selectStudentMapper.getCollege();
        return selectStudentMapper.getCollege();
    }
}
