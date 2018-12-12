package com.youngc.pipeline.mapper.TeacherSeretary;

import com.youngc.pipeline.model.CourseManageModel;
import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.sqlProvider.system.SystemSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElectiveManageMapper {

    @Select("SELECT course_number,course_name,course_nature,course_credit,course_hour FROM Course" +
            " WHERE major_number=#{majorNumber} AND College_number=#{collegeNumber} AND course_nature='选修'")
    List<CourseManageModel> search(@Param("collegeNumber") String collegeNumber,@Param("majorNumber") String majorNumber);

    @Select("SELECT teacher_number,teacher_name FROM Teacher WHERE major_number=#{majorNumber} AND College_number=#{collegeNumber}")
    List<TeacherManageModel> getTeacher(@Param("collegeNumber") String collegeNumber,@Param("majorNumber") String majorNumber);

    @InsertProvider(type = SystemSqlProvider.class, method = "addTeacher")
    boolean addTeacher(@Param("selectTeachers") String selectTeachers,@Param("courseNumber") String courseNumber,@Param("demo") Long demo);
}
