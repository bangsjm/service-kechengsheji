package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youngc.pipeline.mapper.TeacherSeretary.SelectTeacherMapper;
import com.youngc.pipeline.mapper.system.UnitMapper;
import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.model.UnitModel;
import com.youngc.pipeline.service.TeacherSeretary.SelectTeacherService;
import com.youngc.pipeline.service.system.UnitService;
import com.youngc.pipeline.utils.BCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class SelectTeacherServicelmpl implements SelectTeacherService {
    @Autowired
    private SelectTeacherMapper SelectTeacherMapper;

    public Page getmajorTeacher(String selectmajor, String selectcollege, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return (Page) SelectTeacherMapper.getmajorTeacher(selectmajor, selectcollege);
    }
    public Page getcollegeTeacher(String selectcollege, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return (Page) SelectTeacherMapper.getcollegeTeacher(selectcollege);
    }

    public boolean addTeacher(TeacherManageModel teachermanagemodel) {
        return SelectTeacherMapper.addTeacher(teachermanagemodel);
    }

    public String getTeacherNumber(String teacherNumber) {
        return SelectTeacherMapper.getTeacherNumber(teacherNumber);
    }

    public boolean updateTeacher(TeacherManageModel teachermanagemodel) {
        return SelectTeacherMapper.updateTeacher(teachermanagemodel);
    }


    public int deleteTeacherList(String teacherNumbers){
        if(SelectTeacherMapper.selectobligatoryteachers(teacherNumbers)>0)
            return 1;
        else if(SelectTeacherMapper.selectelectives(teacherNumbers)>0)
            return 1;
        else{
            SelectTeacherMapper.deleteTeacherList(teacherNumbers);
            return 0;
        }
    }

    public boolean resetPassword(String teacherNumber){
        String setPassword =new String(teacherNumber.substring(teacherNumber.length()-2));
        String encrypt= BCryptUtil.hashpw(setPassword, BCryptUtil.gensalt(12));
        return SelectTeacherMapper.resetPassword(encrypt,teacherNumber);
    }
}
