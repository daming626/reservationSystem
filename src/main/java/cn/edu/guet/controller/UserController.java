package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("user/addUser.do")
    public void addUser(User user) {

    }

    @RequestMapping("user/viewUser.do")
    public User viewUser() {
        User users = new User();
        return users;
    }

    @RequestMapping("user/deleteUser.do")
    public void deleteUser(String userId) {

    }

    @RequestMapping("user/alterUser.do")
    public void alterUser(User user) {

    }
}