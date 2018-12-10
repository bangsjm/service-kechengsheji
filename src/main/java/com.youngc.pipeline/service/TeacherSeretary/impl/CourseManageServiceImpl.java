package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.youngc.pipeline.mapper.TeacherSeretary.CourseManageMapper;
import com.youngc.pipeline.model.CourseManageModel;
import com.youngc.pipeline.service.TeacherSeretary.CourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManageServiceImpl implements CourseManageService{
    @Autowired
    private CourseManageMapper courseManageMapper;

    public List<CourseManageModel> getCouseByCollegeNumber(String collegeNumber) {
        return courseManageMapper.getCourseByCollegeNumber(collegeNumber);
    }

    public List<CourseManageModel> getCourseByMajorNumber(String collegeNumber,String majorNumber) {
        return courseManageMapper.getCourseByMajorNumber(collegeNumber,majorNumber);
    }

    public int addCourse(CourseManageModel courseManageModel) {
        if(courseManageMapper.isExistsCourse(courseManageModel.getCourseNumber())>0){
            return 0;
        }else {
            return courseManageMapper.addCourse(courseManageModel);
        }
    }

    public int isExistsCourse(String courseNumber) {
        if(courseManageMapper.isExistsCourse(courseNumber) >0){
            return 1;
        }else {
            return 0;
        }
    }
}
