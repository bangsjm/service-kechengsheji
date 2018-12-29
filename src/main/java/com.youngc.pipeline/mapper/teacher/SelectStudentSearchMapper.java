package com.youngc.pipeline.mapper.teacher;

import com.youngc.pipeline.model.ClassManageModel;
import com.youngc.pipeline.model.CourseManageModel;
import com.youngc.pipeline.model.Major;
import com.youngc.pipeline.model.StudentManagerModel;
import com.youngc.pipeline.sqlProvider.system.SystemSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SelectStudentSearchMapper {
    @Select(" SELECT  DISTINCT obligatory_teacher.course_number,course_name FROM obligatory_teacher,Course WHERE year = #{year} AND " +
            "teacher_number = #{teacherNumber} AND obligatory_teacher.course_number = Course.course_number")
    List<CourseManageModel> getCourse(@Param("teacherNumber") String teacherNumber, @Param("year") int year);

    @Select("SELECT DISTINCT Elective_course.course_number,course_name FROM Elective_course,Course  WHERE year = #{year} AND teacher_number = #{teacherNumber} AND Course.course_number = Elective_course.course_number")
    List<CourseManageModel> getCourseElective(@Param("teacherNumber") String teacherNumber, @Param("year") int year);

    @Select("SELECT class_name FROM Class,obligatory_teacher WHERE obligatory_teacher.class_id = Class.class_id AND teacher_number = #{teacherNumber}" +
            " AND course_number = #{courseNumber} AND year = #{year}")
    List<ClassManageModel> getClassName(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year);


    @Select("SELECT major_name,CONCAT(college_number,major_number) FROM Major WHERE major_name in(${majorName})")
    List<Map<String,String>> getXueHao(@Param("majorName") String majorName);

    @SelectProvider(type = SystemSqlProvider.class,method = "selectStudentName")
    List<StudentManagerModel> selectStudentName(@Param("xueHao") List<String>  xueHao,@Param("demo1") Long demo1,@Param("demo2") Long demo2);

    @Select("SELECT Student.student_number,student_name,grade FROM Student,Elective_course,slect_elective_course WHERE slect_elective_course.elective_id = " +
            "Elective_course.elective_id AND slect_elective_course.student_number = Student.student_number AND teacher_number = #{teacherNumber} AND course_number = " +
            "#{courseNumber} AND year = #{year}")
    List<StudentManagerModel> electiveSearch(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year);

    @Select("SELECT Student.student_number,student_name,grade,score FROM Student left join Score on Student.student_number =Score.student_number and course_number = #{courseNumber} " +
            "AND teacher_number =#{teacherNumber} AND Score.year = #{year} " +
            "WHERE Student.student_number IN (${studentNumbers})")
    List<StudentManagerModel> getScores(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year,@Param("studentNumbers") String studentNumbers);

    @Update("UPDATE Score SET score = #{score} WHERE course_number = #{courseNumber} AND teacher_number = #{teacherNumber} AND year = #{year} AND student_number = #{studentNumber}")
    int updateScore(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year,@Param("score") float score,@Param("studentNumber") String studentNumber);

    @Select("SELECT student_number FROM  Elective_course,slect_elective_course WHERE course_number = #{courseNumber} AND" +
            " teacher_number = #{teacherNumber} AND year = #{year} AND Elective_course.elective_id = slect_elective_course.elective_id")
    List<StudentManagerModel> getElectiveStudentNumber(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year);

    @Select("SELECT Student.student_number,student_name,grade,score FROM " +
            "Student left join Score on Student.student_number =Score.student_number and course_number = #{courseNumber} " +
            " AND teacher_number = #{teacherNumber} AND Score.year = #{year}" +
            " WHERE Student.student_number IN (${studentNumbers})")
    List<StudentManagerModel> getElectiveScores(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year,@Param("studentNumbers") String studentNumbers);

    @Select("SELECT COUNT(*) FROM Score WHERE student_number = #{studentNumber} AND teacher_number = #{teacherNumber} AND " +
            "year = #{year} AND course_number = #{courseNumber}")
    int isExitsScore(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year,@Param("studentNumber") String studentNumber);

    @Insert("INSERT INTO Score(student_number,course_number,score,year,teacher_number)" +
            " VALUES(#{studentNumber},#{courseNumber},#{score},#{year},#{teacherNumber})")
    int UpdateNull(@Param("teacherNumber") String teacherNumber,@Param("courseNumber") String courseNumber,@Param("year") int year,@Param("score") float score,@Param("studentNumber") String studentNumber);
}
