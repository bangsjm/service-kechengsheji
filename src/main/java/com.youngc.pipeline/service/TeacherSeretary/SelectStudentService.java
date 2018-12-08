package com.youngc.pipeline.service.TeacherSeretary;

import com.youngc.pipeline.model.College;
import com.youngc.pipeline.result.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SelectStudentService {
    List<College> selectCollege();

    boolean readExcel(MultipartFile file);
}
