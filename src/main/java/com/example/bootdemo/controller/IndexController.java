package com.example.bootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping("/print")
    public String hello() {
        return "启动测试123";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public ModelAndView showIndex2() {
        ModelAndView mv = new ModelAndView("demo1");
        return mv;
    }

    @RequestMapping(value = "/form1", method = RequestMethod.GET)
    public ModelAndView form1() {
        ModelAndView mv = new ModelAndView("form1");
        return mv;
    }
}
