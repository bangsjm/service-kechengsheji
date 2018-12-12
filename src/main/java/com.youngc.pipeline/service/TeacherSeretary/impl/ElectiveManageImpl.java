package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youngc.pipeline.mapper.TeacherSeretary.ElectiveManageMapper;
import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.service.TeacherSeretary.ElectiveManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectiveManageImpl implements ElectiveManageService {

    @Autowired
    private ElectiveManageMapper electiveManageMapper;

    public Page search(String collegeNumber, String majorNumber, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return (Page) electiveManageMapper.search(collegeNumber,majorNumber);

    }

    public List<TeacherManageModel> getTeacher(String collegeNumber, String majorNumber){
        List<TeacherManageModel> teacherManageModels=electiveManageMapper.getTeacher(collegeNumber,majorNumber);
        for(int i=0;i<teacherManageModels.size();i++){
            String teacherNumber=teacherManageModels.get(i).getTeacherNumber();
            teacherManageModels.get(i).setId(teacherNumber);
            teacherManageModels.get(i).setChildren(new ArrayList<TeacherManageModel>());
        }
        return teacherManageModels;
    }

    public boolean addTeacher(String selectTeachers,String courseNumber){
        return electiveManageMapper.addTeacher(selectTeachers,courseNumber,Long.parseLong("1"));
    }
}
