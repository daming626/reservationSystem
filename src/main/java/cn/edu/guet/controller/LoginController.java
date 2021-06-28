package cn.edu.guet.controller;

import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("user/login.do")
    public String login(String username, String password){
        return "";
    }
}
