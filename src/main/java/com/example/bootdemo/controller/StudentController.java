package com.example.bootdemo.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.bootdemo.model.Student;
import com.example.bootdemo.model.vo.FilelistVo;
import com.example.bootdemo.model.vo.ResultVo;
import com.example.bootdemo.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  学生类controller
 * </p>
 *
 * @author wangxj
 * @since 2020-05-08
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/pagelist")
    public ResultVo pageList(Page page, String name, String age){
        Page p = studentService.selectMapsPage(page,new EntityWrapper<Student>()
        .eq(StringUtils.isNotBlank(name),"name",name));
        return new ResultVo(p);
    }

    @RequestMapping("/insertOrUpdate")
    public ResultVo add(Student student, FilelistVo filelist){
        System.out.println(filelist);
        studentService.insertOrUpdate(student);
        return new ResultVo();
    }

    @RequestMapping("/findById")
    public ResultVo findById(String id){
        Student student = studentService.selectById(id);
        return new ResultVo(student);
    }

    @RequestMapping("/delete")
    public ResultVo deleteById(String id){
        boolean b = studentService.deleteById(Integer.parseInt(id));
        return new ResultVo();
    }

    @RequestMapping("/upload")
    public ResultVo upload(MultipartFile file){
        System.out.println(file.getSize());
        String path = "c//test";
        return new ResultVo(path);
    }
}

