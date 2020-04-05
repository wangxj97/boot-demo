package com.example.bootdemo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.bootdemo.mapper.StudentMapper;
import com.example.bootdemo.model.Student;
import com.example.bootdemo.model.Test1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.*;

@SpringBootTest
class BootDemoApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student s = new Student();
        s.setAge("1");
        s.setId(UUID.randomUUID().toString().substring(0,32));
        studentMapper.insert(s);
    }

    @Test
    void update() {
        Student s = new Student();
        s.setId("1");
        s.setAge("1");
        s.setHoppy("测试修改");
        s.setBirthday(Date.valueOf("2013-04-12"));
        studentMapper.updateAllColumnById(s);
    }

    @Test
    void select() {

//        Student s = studentMapper.selectById("1");
//        System.out.println(s);
//
//        //确定返回一条数据
//        Student s1 = new Student();
//        s1.setAge("12");
//        s1.setName("李四");
//        Student student = studentMapper.selectOne(s1);
//        System.out.println(student);
//
//        //可能多条数据
//        Map<String,Object> map = new HashMap<>();
//        map.put("age","1");//这里的key要写表中的列名称
//        List<Student> s3 = studentMapper.selectByMap(map);
//        System.out.println(s3);
//
//        //通过id批量查询
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        List<Student> s4 = studentMapper.selectBatchIds(list);
//        System.out.println(s4);

        //分页查询 第二个参数就是构筑器EntiyWrapper
//        List<Student> s5 = studentMapper.selectPage(new Page<>(1, 2), null);
//        System.out.println(s5);

         //强大的条件构筑器EntiyWrapper  可以构筑一些条件 类似分页,修改和删除的时候都可以使用 这和jooq语法就很像
//        List<Student> s6 = studentMapper.selectList(new EntityWrapper<Student>()
//                .eq("age", "1")
//                .like("name", "张三")
//        );
//        System.out.println(s6);

        //activerecord  其实就是上面的一些方法不用studentMapper调用, 而是直接用student进行调用(但是mapper接口还是要定义的)
        Student student = new Student();
        student.setId("1");
//        student.setName("1");
//        student.setId("234");
//        student.insert();

        //直接用对象操作反而还方便了,直接返回的是page对象 这个student对象的值也不影响查询
        Page<Student> page = student.selectPage(new Page<>(0, 2), null);
        System.out.println(page);

        Test1 test1 = new Test1();


    }

}

