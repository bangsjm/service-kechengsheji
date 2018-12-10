package com.youngc.pipeline.controller.TeacherSecretary;

import com.youngc.pipeline.result.Result;
import com.youngc.pipeline.result.ResultGenerator;
import com.youngc.pipeline.service.TeacherSeretary.TeacherPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TeachingPlan")
public class TeachingPlanController {

    @Autowired
    private TeacherPlanService teacherPlanService;

//    @RequestMapping(path = "/search", method = RequestMethod.GET)
//    @ResponseBody
//    public Result getMajors(@RequestParam String collegeNumber, @RequestParam String majorNumber, @RequestParam int grade,@RequestParam int term){
//        return ResultGenerator.generate();
//    }
}
