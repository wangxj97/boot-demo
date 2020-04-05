package com.example.bootdemo.service.impl;

import com.example.bootdemo.model.Test1;
import com.example.bootdemo.mapper.Test1Mapper;
import com.example.bootdemo.service.Test1Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangxj
 * @since 2020-04-05
 */
@Service
public class Test1ServiceImpl extends ServiceImpl<Test1Mapper, Test1> implements Test1Service {

}
