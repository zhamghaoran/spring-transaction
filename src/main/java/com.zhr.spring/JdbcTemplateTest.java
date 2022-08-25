package com.zhr.spring;

import com.zhr.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  // 指定当前测试类在spring的环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean、
@ContextConfiguration("classpath:spring-jdbc.xml") // 设置spring测试环境的配置文件
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testInsert() {
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"root",123,12,"女","123456@qq.com");

    }

    @Test
    public void testGetUserId() {
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 4);
        System.out.println(user);
    }
    @Test
    public void testGetAllUser() {
        String sql = "select * from t_user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);
    }

}
