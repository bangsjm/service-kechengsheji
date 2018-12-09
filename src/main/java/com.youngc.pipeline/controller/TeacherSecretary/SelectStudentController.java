package com.youngc.pipeline.controller.TeacherSecretary;

import com.youngc.pipeline.result.Result;
import com.youngc.pipeline.result.ResultCode;
import com.youngc.pipeline.result.ResultGenerator;
import com.youngc.pipeline.service.TeacherSeretary.SelectStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/TeacherSecretary")
public class SelectStudentController {

    @Autowired
    private SelectStudentService selectStudentService;

    @RequestMapping(path = "/getCollege", method = RequestMethod.POST)
    @ResponseBody
    public Result getCollege() {
        return ResultGenerator.generate(ResultCode.SUCCESS, selectStudentService.selectCollege());
    }

    @PostMapping(value ="/excelAddStudent")
    public Result excelAddStudent(@RequestParam MultipartFile file) {
        return ResultGenerator.generate(ResultCode.SUCCESS, selectStudentService.readExcel(file));
    }

    @RequestMapping(path = "/getMajor", method = RequestMethod.POST)
    @ResponseBody
    public Result getMajor(String collegeNumber){
        return  ResultGenerator.generate(ResultCode.SUCCESS, selectStudentService.selectMajor(collegeNumber));
    }

    @RequestMapping(path = "/getClass", method = RequestMethod.POST)
    @ResponseBody
    public Result getClass(String majorName){
        System.out.println(123456);
        System.out.println(majorName);
        return ResultGenerator.generate(ResultCode.SUCCESS, selectStudentService.selectClass(majorName));
    }
}
