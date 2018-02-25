package com.qihang.controller;

import com.qihang.model.User;
import com.qihang.serviceImpl.UserServiceImpl;
import com.qihang.util.Msg;
import com.qihang.util.TableConstants;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/testUser")
    @ResponseBody
    public Msg testUser(
            @RequestParam("name") String name,
            @RequestParam("pass") String pass,
            HttpServletRequest request
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //使用MD5加密
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newpass = base64en.encode(md5.digest(pass.getBytes("utf-8")));
        User user = userService.testUser(name,newpass);

        HttpSession session = request.getSession();
        if (user!=null && "5".equals(user.getPower())){
            session.setAttribute("user",user);
            Msg msg = new Msg();
            //代表管理员
            msg.setCode(201);
            return msg;
        }else if (user!=null && !"5".equals(user.getPower())){
            session.setAttribute("user",user);
            return Msg.success();
        }
        return Msg.fail();
    }

    @RequestMapping(value = "/getZhongUser")
    @ResponseBody
    public Msg getZhongUser(
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(TableConstants.USER_SESSION);
        List<User> users = userService.getUserNameByRiSy(2,Integer.valueOf(user.getSystem())); //此处的系代码需要动态!!!!!
        List<User> users2 = userService.getUserNameByRiSy(4,Integer.valueOf(user.getSystem())); //此处的系代码需要动态!!!!!
        for (int i = 0; i < users2.size(); i++) {
            users.add(users2.get(i));
        }
        return Msg.success().add("users",users);
    }
    @RequestMapping(value = "/getGaoUser")
    @ResponseBody
    public Msg getGaoUser(
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(TableConstants.USER_SESSION);
        List<User> users = userService.getUserNameByRiSy(3,Integer.valueOf(user.getSystem())); //此处的系代码需要动态!!!!!
        return Msg.success().add("users",users);
    }
}
