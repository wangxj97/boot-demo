package com.example.bootdemo.service.impl;

import com.example.bootdemo.model.Student;
import com.example.bootdemo.mapper.StudentMapper;
import com.example.bootdemo.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangxj
 * @since 2020-05-08
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
