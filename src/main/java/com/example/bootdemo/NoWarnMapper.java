package com.example.bootdemo;

import org.apache.ibatis.annotations.Mapper;

/**
 * doScan()会扫描启动类同级目录下的mapper接口，没有的话会报出一个警告(如果想让启动日志中没有这个警告,就要这个类)
 * 但是合理的目录结果绝对不允许所有的mapper都在启动类目录下，所以在启动类目录下添加了一个伪mapper
 */
@Mapper
public interface NoWarnMapper {
}
