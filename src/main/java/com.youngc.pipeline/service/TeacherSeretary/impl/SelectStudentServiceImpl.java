package com.youngc.pipeline.service.TeacherSeretary.impl;

import com.youngc.pipeline.mapper.TeacherSeretary.SelectStudentMapper;
import com.youngc.pipeline.model.ClassModel;
import com.youngc.pipeline.model.College;
import com.youngc.pipeline.model.StudentManagerModel;
import com.youngc.pipeline.model.Major;
import com.youngc.pipeline.service.TeacherSeretary.SelectStudentService;
import com.youngc.pipeline.utils.BCryptUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectStudentServiceImpl implements SelectStudentService {

    @Autowired
    private SelectStudentMapper selectStudentMapper;

    public List<College> selectCollege(){
        List<College> demo=selectStudentMapper.getCollege();
        return selectStudentMapper.getCollege();
    }

    public boolean readExcel(MultipartFile file){
        List<StudentManagerModel> data=new ArrayList<StudentManagerModel>();
        FileInputStream input=null;
        try{
            input = (FileInputStream)file.getInputStream();
            Workbook workBook = WorkbookFactory.create(input);
            int numberOfSheets = workBook.getNumberOfSheets();
            for (int s = 0; s < numberOfSheets; s++) { // sheet工作表
                Sheet sheetAt = workBook.getSheetAt(s);
                int rowsOfSheet = sheetAt.getPhysicalNumberOfRows(); // 获取当前Sheet的总列数
                for (int r = 1; r < rowsOfSheet; r++) { // 总行
                    Row row = sheetAt.getRow(r);
                    if (row == null) {
                        continue;
                    } else {
                        StudentManagerModel studentManagerModel=new StudentManagerModel();
                        studentManagerModel.setStudentNumber(row.getCell(0)!=null?"'"+row.getCell(0).getStringCellValue()+"'":null);
                        studentManagerModel.setStudentName(row.getCell(1)!=null?"'"+row.getCell(1).getStringCellValue()+"'":null);
                        studentManagerModel.setSex(row.getCell(2)!=null?"'"+row.getCell(2).getStringCellValue()+"'":null);
                        studentManagerModel.setEntranceYear(row.getCell(3)!=null?Long.parseLong(new java.text.DecimalFormat("0").format(row.getCell(3).getNumericCellValue())):null);
                        studentManagerModel.setEmail(row.getCell(4)!=null?"'"+row.getCell(4).getStringCellValue()+"'":null);
                        studentManagerModel.setGrade(row.getCell(5)!=null?Long.parseLong(new java.text.DecimalFormat("0").format(row.getCell(5).getNumericCellValue())):null);
                        String password=row.getCell(6)!=null?"'"+row.getCell(6).getStringCellValue()+"'":null;
                        studentManagerModel.setPassword(BCryptUtil.hashpw(password, BCryptUtil.gensalt(12)));
                        data.add(studentManagerModel);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (input!= null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        selectStudentMapper.addStudentExcel(data,Long.parseLong("1"),Long.parseLong("2"));
        return true;
    }


    public List<Major> selectMajor(String collegeNumber){
        List<Major> majors = selectStudentMapper.getMajor(collegeNumber);
        return majors;
    }

    public List<ClassModel> selectClass(String majorName) {
        List<ClassModel> classes = selectStudentMapper.getClass(majorName);
        return classes;
    }
}
