package com.youngc.pipeline.service.TeacherSeretary;

import com.youngc.pipeline.bean.auth.MajorBean;
import com.youngc.pipeline.model.Major;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

public interface SelectMajorService {
    Page getMajors(String collegeNumber,int pageNum,int pageSize);

    boolean addMajor(Major major);

    int updateMajor(Major major);

}
