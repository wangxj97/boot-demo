package com.example.bootdemo.common.config;

import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    /***
     * plus 的性能分析插件
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /* <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 --> */
        //performanceInterceptor.setMaxTime(1000);
        /* <!--SQL是否格式化 默认false--> */
        performanceInterceptor.setFormat(false);
        return performanceInterceptor;
    }

    /***
     * plus 的执行分析插件,对全表的删除或者更新操作时会抛出异常
     */
    @Bean
    public SqlExplainInterceptor SqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        sqlExplainInterceptor.setStopProceed(true);
        return sqlExplainInterceptor;
    }

    /**
     * mybatis-plus 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
