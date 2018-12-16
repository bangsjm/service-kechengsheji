package com.youngc.pipeline.controller.Student;

import com.youngc.pipeline.result.Result;
import com.youngc.pipeline.result.ResultCode;
import com.youngc.pipeline.result.ResultGenerator;
import com.youngc.pipeline.service.Student.SearchCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StudentCourse")
public class SearchCourseController {

    @Autowired
    SearchCourseService searchCourseService;

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Result selectCourseByCollege(@RequestParam int year,@RequestParam String studentNumber,@RequestParam int pageNum, @RequestParam int pageSize){
        return ResultGenerator.generate(searchCourseService.search(studentNumber,year,pageNum,pageSize));

    }

}
