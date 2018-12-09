package com.youngc.pipeline.mapper.TeacherSeretary;

import com.youngc.pipeline.model.College;
import com.youngc.pipeline.model.Major;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SelectMajorMapper {
    @Select("select major_number,major_name,College_name,open_year from Major,College where College.College_number = " +
            "Major.college_number and Major.college_number= #{colNum}")
    List<Major> getMajors(@Param("colNum") String collegeNumber);

    @Insert("INSERT INTO Major(major_number,major_name,college_number,open_year) VALUES" +
            "(#{majorNumber},#{majorName},#{collegeNumber},#{openYear})")
    boolean addMajor(Major major);

    @Update("UPDATE Major SET major_number=#{majorNumber},major_name=#{majorName},college_number=#{collegeNumber},open_year=#{openYear}" +
            "WHERE major_number=#{oldMajorNumber} ")
    int updateMajor(Major major);
//    @Delete("DELETE FROM Major WHERE major_number IN (${deleteMajors})")
//    boolean deleteMajors()

    @Select("SELECT COUNT(major_number) FROM Major WHERE major_number = #{majorNumber} AND college_number=#{collegeNumber}")
    int isMajorExists(Major major);
}
