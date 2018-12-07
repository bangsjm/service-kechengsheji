package com.youngc.pipeline.controller.TeacherSecretary;

import com.youngc.pipeline.result.Result;
import com.youngc.pipeline.result.ResultCode;
import com.youngc.pipeline.result.ResultGenerator;
import com.youngc.pipeline.service.TeacherSeretary.SelectStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
