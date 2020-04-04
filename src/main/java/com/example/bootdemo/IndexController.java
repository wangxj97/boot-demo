package com.example.bootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String hello() {
        return "启动测试成功";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
