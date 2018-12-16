package com.youngc.pipeline.service.Student.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youngc.pipeline.mapper.Student.SearchCourseMapper;
import com.youngc.pipeline.model.CourseTeacherModel;
import com.youngc.pipeline.service.Student.SearchCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCourseImpl implements SearchCourseService{

    @Autowired
    SearchCourseMapper searchCourseMapper;

    public Page search(String studentNumber,int year, int pageNum, int pageSize){
        //List<CourseTeacherModel> elective=searchCourseMapper.searchElective(studentNumber,year);
        String collegeNumber=studentNumber.substring(2,4);
        String majorNumber=studentNumber.substring(4,6);
        String class1=studentNumber.substring(7,8);
        String yearStudent=studentNumber.substring(0,2);
        String majorName=searchCourseMapper.getMajorName(collegeNumber,majorNumber);
        String className=majorName+yearStudent+class1;
        List<CourseTeacherModel> obligatory=searchCourseMapper.searchElective(className,studentNumber,year);
        //obligatory.addAll(elective);

        PageHelper.startPage(pageNum,pageSize);
        return (Page) searchCourseMapper.searchElective(className,studentNumber,year);
    }
}
