package com.youngc.pipeline.mapper.Student;

import com.youngc.pipeline.model.CourseManageModel;
import com.youngc.pipeline.model.CourseTeacherModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface SearchCourseMapper {

    @Select("SELECT Course.course_number,Course.course_name,Course.course_credit,Course.course_nature," +
            "Teacher.teacher_number,Teacher.teacher_name " +
            "FROM Course,Teacher,slect_elective_course,Elective_course WHERE " +
            "slect_elective_course.student_number=#{studentNumber} AND slect_elective_course.elective_id=Elective_course.elective_id " +
            "AND Elective_course.year=#{year} AND  Elective_course.teacher_number=Teacher.teacher_number " +
            "AND Elective_course.course_number=Course.course_number UNION " +
            "SELECT Course.course_number,Course.course_name,Course.course_credit,Course.course_nature," +
            "Teacher.teacher_number,Teacher.teacher_name " +
            "FROM Course,Teacher,obligatory_teacher,Class WHERE " +
            "Class.class_name=#{className} AND Class.class_id=obligatory_teacher.class_id AND obligatory_teacher.year=#{year} " +
            "AND obligatory_teacher.course_number=Course.course_number AND obligatory_teacher.teacher_number=Teacher.teacher_number")
    List<CourseTeacherModel> searchElective(@Param("className") String className,@Param("studentNumber") String studentNumber,@Param("year") int year);

    @Select("SELECT Course.course_number,Course.course_name,Course.course_credit,Course.course_nature," +
            "Teacher.teacher_number,Teacher.teacher_name " +
            "FROM Course,Teacher,obligatory_teacher,Class WHERE " +
            "Class.class_name=#{className} AND Class.class_id=obligatory_teacher.class_id AND obligatory_teacher.year=#{year}")
    List<CourseTeacherModel> searchObligatory(@Param("className") String className,@Param("year") int year);

    @Select("SELECT major_name FROM Major WHERE major_number=#{majorNumber} AND college_number=#{collegeNumber}")
    String getMajorName(@Param("collegeNumber") String collegeNumber,@Param("majorNumber") String majorNumber);
}
