package com.youngc.pipeline.service.TeacherSeretary;

import com.youngc.pipeline.model.CourseManageModel;

import java.util.List;

public interface CourseManageService {
    List<CourseManageModel> getCouseByCollegeNumber(String collegeNumber);

    List<CourseManageModel> getCourseByMajorNumber(String collegeNumber,String majorNumber);

    int addCourse(CourseManageModel courseManageModel);

    int isExistsCourse(String courseNumber);
}
