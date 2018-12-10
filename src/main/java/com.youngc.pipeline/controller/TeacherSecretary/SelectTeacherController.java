package com.youngc.pipeline.controller.TeacherSecretary;

import com.youngc.pipeline.bean.auth.TeacherBean;
import com.youngc.pipeline.bean.param.UserBean;
import com.youngc.pipeline.model.TeacherManageModel;
import com.youngc.pipeline.model.UserManagerModel;
import com.youngc.pipeline.result.Result;
import com.youngc.pipeline.result.ResultCode;
import com.youngc.pipeline.result.ResultGenerator;
import com.youngc.pipeline.service.TeacherSeretary.SelectTeacherService;
import com.youngc.pipeline.service.system.UserManagerService;
import com.youngc.pipeline.utils.BCryptUtil;
import com.youngc.pipeline.utils.RequestContextHolderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TeacherSecretary")
public class SelectTeacherController {
    @Autowired
    private SelectTeacherService selectTeacherService;

    @RequestMapping(path = "/Teacher", method = RequestMethod.GET)
    @ResponseBody
    public Result getTeacher(@RequestParam String selectmajor, @RequestParam String selectcollege, @RequestParam int pageNum, @RequestParam int pageSize) {
        if(selectmajor==""||selectmajor==null)
            return ResultGenerator.generate(selectTeacherService.getcollegeTeacher(selectcollege, pageNum, pageSize));
        else
        return ResultGenerator.generate(selectTeacherService.getmajorTeacher(selectmajor, selectcollege, pageNum, pageSize));
    }

    @RequestMapping(path = "/TeacherAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result postTeacher(@RequestBody TeacherBean teacherBean) {
        TeacherManageModel teachermanagemodel = new TeacherManageModel();
        teachermanagemodel.setTeacherNumber(teacherBean.getTeacherNumber());
        teachermanagemodel.setTeacherName(teacherBean.getTeacherName());
        teachermanagemodel.setSelectcollege(teacherBean.getSelectcollege());
        teachermanagemodel.setSelectmajor(teacherBean.getSelectmajor());
        String pad= BCryptUtil.hashpw(teacherBean.getPassword(), BCryptUtil.gensalt(12));
        teachermanagemodel.setPassword(pad);
        teachermanagemodel.setHiredate(teacherBean.getHiredate());
        teachermanagemodel.setProf(teacherBean.getProf());
        teachermanagemodel.setEmail(teacherBean.getEmail());


        return ResultGenerator.generate(ResultCode.SUCCESS,
                selectTeacherService.addTeacher(teachermanagemodel));
    }

    @RequestMapping(path = "/Teacherinfo", method = RequestMethod.POST)
    @ResponseBody
    public Result getTeacherNumber(@RequestParam String teacherNumber) {
        return ResultGenerator.generate(ResultCode.SUCCESS, selectTeacherService.getTeacherNumber(teacherNumber));
    }

    @RequestMapping(path = "/Teacherupdate", method = RequestMethod.PUT)
    @ResponseBody
    public Result putTeacher(@RequestBody TeacherBean teacherBean) {

        TeacherManageModel teachermanagemodel = new TeacherManageModel();
        teachermanagemodel.setOtherteacherNumber(teacherBean.getOtherteacherNumber());
        teachermanagemodel.setTeacherName(teacherBean.getTeacherName());
        teachermanagemodel.setSelectcollege(teacherBean.getSelectcollege());
        teachermanagemodel.setSelectmajor(teacherBean.getSelectmajor());
        teachermanagemodel.setHiredate(teacherBean.getHiredate());
        teachermanagemodel.setProf(teacherBean.getProf());
        teachermanagemodel.setEmail(teacherBean.getEmail());
        return ResultGenerator.generate(ResultCode.SUCCESS, selectTeacherService.updateTeacher(teachermanagemodel));
    }

    @DeleteMapping(path = "/Teacherdelete")
    public Result deleteTeacherList(@RequestParam("teacherNumbers") String teacherNumbers) {

        return ResultGenerator.generate(ResultCode.SUCCESS,selectTeacherService.deleteTeacherList(teacherNumbers));
    }

    @RequestMapping(path = "/resetpassword", method = RequestMethod.POST)
    @ResponseBody
    public Result resetPassword(@RequestParam String teacherNumber){
        return ResultGenerator.generate(ResultCode.SUCCESS,selectTeacherService.resetPassword(teacherNumber));
    }
}
