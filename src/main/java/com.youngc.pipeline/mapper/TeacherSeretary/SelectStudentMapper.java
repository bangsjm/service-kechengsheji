package com.youngc.pipeline.mapper.TeacherSeretary;

import com.youngc.pipeline.model.College;
import com.youngc.pipeline.model.StudentManagerModel;
import com.youngc.pipeline.sqlProvider.system.SystemSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SelectStudentMapper {

    @Select("select College_number,College_name from College")
    List<College> getCollege();

    @InsertProvider(type = SystemSqlProvider.class, method = "addStudentExcel")
    boolean addStudentExcel(List<StudentManagerModel> data,Long userId,Long devId);
}
