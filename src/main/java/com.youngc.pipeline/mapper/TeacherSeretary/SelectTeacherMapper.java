package com.youngc.pipeline.mapper.TeacherSeretary;

import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.sqlProvider.system.SystemSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.Date;

import java.util.List;

@Component
public interface SelectTeacherMapper {
    @Select("SELECT teacher_number,teacher_name,password,hiredate,prof,e_mail from Teacher " +
            "WHERE (major_number=#{selectmajor}) and (College_number=#{selectcollege})")
    List<TeacherManageModel> getmajorTeacher(@Param("selectmajor") String selectmajor,@Param("selectcollege") String selectcollege);

    @Select("SELECT teacher_number,teacher_name,password,hiredate,prof,e_mail from Teacher WHERE College_number=#{selectcollege}")
    List<TeacherManageModel> getcollegeTeacher(@Param("selectcollege") String selectcollege);

    @Insert("insert into Teacher (teacher_number,teacher_name,password,hiredate,e_mail,College_number,major_number,prof)"+
    "values(#{teacherNumber},#{teacherName},#{password},#{hiredate},#{email},#{selectcollege},#{selectmajor},#{prof})")
    boolean addTeacher(TeacherManageModel teachermanagemodel);

    @Select("select teacher_number from Teacher where teacher_number=#{teacherNumber}")
    String getTeacherNumber(String teacherNumber);

    @Update("update Teacher set teacher_name=#{teacherName}," +
            "hiredate=#{hiredate},e_mail=#{email},College_number=#{selectcollege},major_number=#{selectmajor},prof=#{prof}" +
            "where teacher_number=#{otherteacherNumber}" )
    boolean updateTeacher(TeacherManageModel teachermanagemodel);

    @Select("select count(*) from Elective_course where teacher_number in (${teacherNumbers})")
    int selectelectives(@Param("teacherNumbers") String teacherNumbers);

    @Select("select count(*) from obligatory_teacher where teacher_number in (${teacherNumbers})")
    int selectobligatoryteachers(@Param("teacherNumbers") String teacherNumbers);

    @Delete("DELETE FROM Teacher where teacher_number in (${teacherNumbers})")
    int deleteTeacherList(@Param("teacherNumbers") String teacherNumbers);

    @Update("update Teacher set password=#{encrypt} where teacher_number=#{teacherNumber}")
    boolean resetPassword(@Param("encrypt") String encrypt,@Param("teacherNumber") String teacherNumber);
}
