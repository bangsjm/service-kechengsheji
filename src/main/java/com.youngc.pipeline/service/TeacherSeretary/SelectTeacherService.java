package com.youngc.pipeline.service.TeacherSeretary;

import com.github.pagehelper.Page;
import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.model.UnitModel;
import com.youngc.pipeline.model.UserManagerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectTeacherService {
    Page getmajorTeacher(String selectmajor,String selectcollege,int pageNum, int pageSize);
    Page getcollegeTeacher(String selectcollege, int pageNum, int pageSize);
    boolean addTeacher(TeacherManageModel teachermanagemodel);
    String getTeacherNumber(String teacherNumber);
    boolean updateTeacher(TeacherManageModel teachermanagemodel);
    int deleteTeacherList(String teacherNumbers);
    boolean resetPassword(String teacherNumber);
}
