package com.youngc.pipeline.service.Student.impl;

import com.youngc.pipeline.mapper.Student.SearchScoreMapper;
import com.youngc.pipeline.model.ScoreModel;
import com.youngc.pipeline.service.Student.SearchScoreService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youngc.pipeline.mapper.TeacherSeretary.SelectTeacherMapper;
import com.youngc.pipeline.mapper.system.UnitMapper;
import com.youngc.pipeline.model.Major;
import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.model.UnitModel;
import com.youngc.pipeline.service.TeacherSeretary.SelectTeacherService;
import com.youngc.pipeline.service.system.UnitService;
import com.youngc.pipeline.utils.BCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SearchScoreServiceImpl implements SearchScoreService {
    @Autowired
    private SearchScoreMapper searchScoreMapper;

    public List<ScoreModel> getSelfScore(String studentNumber,int pageNum,int pageSize){

        PageHelper.startPage(pageNum, pageSize);

        return (Page) searchScoreMapper.getSelfScore(studentNumber);
    }

    public List<ScoreModel> getCourseScore(String studentNumber,int pageNum,int pageSize){

        PageHelper.startPage(pageNum, pageSize);

        return (Page) searchScoreMapper.getCourseScore(studentNumber);
    }
}
