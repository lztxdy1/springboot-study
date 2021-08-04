package com.wang.controller;

import com.wang.entity.User;
import com.wang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 查询所有用户
    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    // 通过id查用户
    @GetMapping("/queryUserById")
    public String queryUserById() {
        User user = userMapper.queryUserById(6);
        System.out.println(user);
        return "查询成功";
    }

    // 增加新用户
    @GetMapping("/addUser")
    public String addUser() {
        int i = userMapper.addUser(new User(7, "Jams", "123456"));
        if (i > 0) {
            System.out.println("插入成功");
        }
        return "addUser success";
    }

    // 修改用户
    @GetMapping("/updateUser")
    public String updateUser() {
        int i = userMapper.updateUser(new User(7, "Jams Harden", "123456"));
        if (i > 0) {
            System.out.println("更新成功");
        }
        return "updateUser success";
    }

    // 删除用户
    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(7);
        return "deleteUser success";
    }
}
