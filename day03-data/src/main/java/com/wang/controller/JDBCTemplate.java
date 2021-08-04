package com.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCTemplate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/listUser")
    public List<Map<String, Object>> listUser() {
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
        return userList;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id, name, pwd) values (6, 'Alex', '123456')";
        jdbcTemplate.update(sql);
        return "insert-success";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id) {
        String sql = "update mybatis.user set name=?,pwd=? where id = " + id;
        Object[] objects = new Object[2];
        objects[0] = "修改测试";
        objects[1] = "123456789";
        jdbcTemplate.update(sql, objects);
        return "update-success";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        String sql = "delete from mybatis.user where id = ?";
        jdbcTemplate.update(sql, id);
        return "delete-success";
    }
}
