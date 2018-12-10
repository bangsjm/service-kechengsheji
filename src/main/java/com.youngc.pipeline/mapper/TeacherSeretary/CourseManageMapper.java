package com.youngc.pipeline.mapper.TeacherSeretary;

import com.youngc.pipeline.model.CourseManageModel;
import com.youngc.pipeline.model.Major;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseManageMapper {
    @Select("select course_number,course_name,course_nature,course_credit,course_hour from Course WHERE College_number = #{colNum}")
    List<CourseManageModel> getCourseByCollegeNumber(@Param("colNum") String collegeNumber);

    @Select("select course_number,course_name,course_nature,course_credit,course_hour from Course WHERE College_number = #{colNum} AND major_number = #{majorNum}")
    List<CourseManageModel> getCourseByMajorNumber(@Param("colNum") String collegeNumber,@Param("majorNum") String majorNumber);

    //检验课程号是否已经存在
    @Select("SELECT COUNT(*) FROM  Course WHERE course_number =#{courseNumber}")
    int isExistsCourse(String courseNumber);
    //添加课程
    @Insert("INSERT INTO Course(course_number,course_name,course_nature,course_credit,course_hour,major_number,college_number)" +
            "VALUES(#{courseNumber},#{courseName},#{courseNature},#{courseCredit},#{courseHour},#{majorNumber},#{collegeNumber})")
    int addCourse(CourseManageModel courseManageModel);
}
