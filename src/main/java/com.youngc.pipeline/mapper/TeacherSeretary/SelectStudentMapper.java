package com.youngc.pipeline.mapper.TeacherSeretary;

import com.youngc.pipeline.model.College;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SelectStudentMapper {

    @Select("select College_number,College_name from College")
    List<College> getCollege();
}
