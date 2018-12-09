package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youngc.pipeline.mapper.TeacherSeretary.SelectMajorMapper;
import com.youngc.pipeline.model.Major;
import com.youngc.pipeline.service.TeacherSeretary.SelectMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelectMajorServiceImpl implements SelectMajorService{
    @Autowired
    private SelectMajorMapper selectMajorMapper;


    public Page getMajors(String collegeNumber, int pageNum, int pageSize) {
        System.out.println(collegeNumber);
        PageHelper.startPage(pageNum,pageSize);
        return (Page) selectMajorMapper.getMajors(collegeNumber);
    }

    public boolean addMajor(Major major) {
        selectMajorMapper.addMajor(major);
        return true;
    }

    public int updateMajor(Major major) {
        if(selectMajorMapper.isMajorExists(major) == 1){
            return 0;
        }else {
            return selectMajorMapper.updateMajor(major);
        }
    }



}
