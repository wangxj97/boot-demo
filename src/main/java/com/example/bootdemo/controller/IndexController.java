package com.example.bootdemo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.bootdemo.mapper.StudentMapper;
import com.example.bootdemo.model.Student;
import com.example.bootdemo.model.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/print")
    public String hello() {
        //一般封装一个返回类, 包含状态码,提示,完整数据
        //把查询的数据

        return "启动测试123";
    }

    @RequestMapping("/t1")
    public ResultVo t1(String name) {
        //一般封装一个返回类, 包含状态码,提示,完整数据
        //把查询的数据
        Map map = new HashMap();
        map.put("test","123");
        map.put("msg","我是说");
        return new ResultVo(map);
    }
    @RequestMapping("/t2")
    public ResultVo t2(String name) {
        //一般封装一个返回类, 包含状态码,提示,完整数据
        //把查询的数据
        Map map = new HashMap();
        map.put("test","123");
        int a = 1/0;
        return new ResultVo();
    }

    @RequestMapping("/tr")
    @Transactional
    public String tr() {
        Student student = new Student();
        studentMapper.insert(student);
        int a = 1/0;
        Student s2 = new Student();
        student.insert();

        return "启动测试123";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/demo1/{name}", method = RequestMethod.GET)
    public ModelAndView showIndex2(@PathVariable String name) {
        ModelAndView mv = new ModelAndView("demo1");
        return mv;
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public ModelAndView showIndex22(Page<Student> page,Student s) {
        ModelAndView mv = new ModelAndView("demo2");
        return mv;
    }

    @RequestMapping(value = "/form1", method = RequestMethod.GET)
    public ModelAndView form1() {
        ModelAndView mv = new ModelAndView("form1");
        mv.getModel().put("name","fdsfd");
        return mv;
    }
}
