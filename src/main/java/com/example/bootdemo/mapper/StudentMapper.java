package com.example.bootdemo.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.bootdemo.model.Student;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangxj
 * @since 2020-04-22
 */
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select a.name as name,a.sex as sex,b.name as username from student a left join test1 b on a.age = b.age where 1=1 " +
            " ${ew.getSqlSegment}")
    public List<Student> selectVo(Page<Student> page1, @Param("ew") Wrapper<Student> var2);

}
