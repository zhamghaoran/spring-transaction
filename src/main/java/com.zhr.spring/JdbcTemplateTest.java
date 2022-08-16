package com.zhr.spring;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  // 指定当前测试类在spring的环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean、
@ContextConfiguration("classpath:spring-jdbc.xml") // 设置spring测试环境的配置文件
public class testJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testInsert() {
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"root",123,12,"女","123456@qq.com");

    }

}
