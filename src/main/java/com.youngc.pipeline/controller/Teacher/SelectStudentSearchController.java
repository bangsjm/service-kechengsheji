package com.youngc.pipeline.controller.Teacher;

import com.youngc.pipeline.result.Result;
import com.youngc.pipeline.result.ResultCode;
import com.youngc.pipeline.result.ResultGenerator;
import com.youngc.pipeline.service.Teacher.SelectStudentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/Teacher")
public class SelectStudentSearchController {
    @Autowired
    private SelectStudentSearchService selectStudentSearchService;

    @RequestMapping(path = "/getCourse", method = RequestMethod.POST)
    @ResponseBody
    public Result getCourse(@RequestParam String teacherNumber,@RequestParam int year){
        return ResultGenerator.generate(ResultCode.SUCCESS,selectStudentSearchService.getCourse(teacherNumber,year));
    }

    @RequestMapping(path = "/getCourseElective", method = RequestMethod.POST)
    @ResponseBody
    public Result getCourseElective(@RequestParam String teacherNumber,@RequestParam int year){
        return ResultGenerator.generate(ResultCode.SUCCESS,selectStudentSearchService.getCourseElective(teacherNumber,year));
    }

    @RequestMapping(path = "/SelectStudentSearch", method = RequestMethod.GET)
    @ResponseBody
    public Result selectStudentSearch(@RequestParam String teacherNumber,@RequestParam String courseNumber,@RequestParam int year,
                                      @RequestParam int pageNum,@RequestParam int pageSize){
        return ResultGenerator.generate(selectStudentSearchService.selectStudent(teacherNumber,courseNumber,year,pageNum,pageSize));
    }

    @GetMapping("/DownLoadExcel")
    public String downloadFileInfo(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam String teacherNumber,@RequestParam String courseNumber,@RequestParam int year) {
        return selectStudentSearchService.downloadFileInfo(request,response,teacherNumber,courseNumber,year);
    }

    @RequestMapping(path = "/ElectiveSearch", method = RequestMethod.GET)
    @ResponseBody
    public Result electiveSearch(@RequestParam String teacherNumber,@RequestParam String courseNumber,@RequestParam int year,
                                      @RequestParam int pageNum,@RequestParam int pageSize){
        return ResultGenerator.generate(selectStudentSearchService.electiveSearch(teacherNumber,courseNumber,year,pageNum,pageSize));
    }

    @RequestMapping(path = "/ScoreSearch", method = RequestMethod.GET)
    @ResponseBody
    public Result ScoreSearch(@RequestParam String teacherNumber,@RequestParam String courseNumber,@RequestParam int year,
                                 @RequestParam int pageNum,@RequestParam int pageSize,@RequestParam String nature){
        if (nature.equals("必修")){
            return ResultGenerator.generate(selectStudentSearchService.getScores(teacherNumber,courseNumber,year,pageNum,pageSize));
        }else{
            return ResultGenerator.generate(selectStudentSearchService.getElectiveScore(teacherNumber,courseNumber,year,pageNum,pageSize));
        }
    }

    @RequestMapping(path = "/UpdateScore", method = RequestMethod.GET)
    @ResponseBody
    public Result UpdateScore(@RequestParam String teacherNumber,@RequestParam String courseNumber,@RequestParam int year,
                              @RequestParam float score,@RequestParam String studentNumber,@RequestParam float oldScore){
        return ResultGenerator.generate(ResultCode.SUCCESS,selectStudentSearchService.updateScore(teacherNumber,courseNumber,year,score,studentNumber,oldScore));
    }


    @RequestMapping(path = "/AddScore", method = RequestMethod.GET)
    @ResponseBody
    public Result UpdateScore(@RequestParam String teacherNumber,@RequestParam String courseNumber,@RequestParam int year,
                              @RequestParam float score,@RequestParam String studentNumber){
        return ResultGenerator.generate(ResultCode.SUCCESS,selectStudentSearchService.fillInScore(teacherNumber,courseNumber,year,studentNumber,score));
    }
}
