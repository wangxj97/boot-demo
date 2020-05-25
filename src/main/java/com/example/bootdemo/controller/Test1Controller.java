package com.example.bootdemo.controller;


import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangxj
 * @since 2020-04-05
 */
@Controller
@RequestMapping("/test1")
public class Test1Controller {
    static volatile int  i = 0;
    static Map<String,String>  map  = new HashMap<>(12,1);
    public static void main(String[] args) {

//        static boolean flag = true;

        map.put("1","1");

        map = Collections.unmodifiableMap(map);
//        map.put("2","2");
        System.out.println(map);



    }


}


