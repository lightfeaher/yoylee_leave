package com.qihang.controller;

import com.qihang.model.User;
import com.qihang.serviceImpl.UserServiceImpl;
import com.qihang.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/getZhongUser")
    @ResponseBody
    public Msg getZhongUser(){
        List<User> users = userService.GetUserNameByRiSy(2,1); //此处的系代码需要动态!!!!!
        List<User> users2 = userService.GetUserNameByRiSy(4,1); //此处的系代码需要动态!!!!!
        for (int i = 0; i < users2.size(); i++) {
            users.add(users2.get(i));
        }
        return Msg.success().add("users",users);
    }
    @RequestMapping(value = "/getGaoUser")
    @ResponseBody
    public Msg getGaoUser(){
        List<User> users = userService.GetUserNameByRiSy(3,1); //此处的系代码需要动态!!!!!
        return Msg.success().add("users",users);
    }
}
