package com.qihang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qihang.model.User;
import com.qihang.model.User2;
import com.qihang.serviceImpl.UserServiceImpl;
import com.qihang.util.Msg;
import com.qihang.util.TableConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value = "/getAllUser")
    @ResponseBody
    public Msg getAllUser(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn
    ){
        PageHelper.startPage(pn, 7);
        List<User2> users = userService.selectAllUser();
        PageInfo pageInfo = new PageInfo(users, 7);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @RequestMapping(value = "/getUserById")
    @ResponseBody
    public Msg getUserById(
            @RequestParam("id") int id
    ){
        User user = userService.getUserById(id);
        if (user!=null)
            return Msg.success().add("user",user);
        return Msg.fail();
    }

    @RequestMapping(value = "/getUserByLike")
    @ResponseBody
    public Msg getUserByLike(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam("systemId") int systemId,
            @RequestParam("nameId") String name
    ){
        PageHelper.startPage(pn, 7);
        List<User2> users = userService.getUserByLike(systemId,name);
        PageInfo pageInfo = new PageInfo(users, 7);
        return Msg.success().add("pageInfo",pageInfo);
    }

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
        if (user!=null && "5".equals(user.getPost())){
            session.setAttribute("user",user);
            Msg msg = new Msg();
            //代表管理员
            msg.setCode(201);
            return msg;
        }else if (user!=null && !"5".equals(user.getPost())){
            session.setAttribute("user",user);
            return Msg.success();
        }
        return Msg.fail();
    }

    @RequestMapping(value = "/changePassword")
    @ResponseBody
    public Msg changePassword(
            @RequestParam("oldpass") String oldpass,
            @RequestParam("newpass1") String newpass1,
            @RequestParam("newpass2") String newpass2,
            HttpServletRequest request,
            Msg msg
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        HttpSession session = request.getSession();
        if (newpass1.equals(newpass2)){
            //判断该用户的旧密码是否正确
            User user = (User) session.getAttribute(TableConstants.USER_SESSION);
            if (user!=null){
                MessageDigest md5=MessageDigest.getInstance("MD5");
                BASE64Encoder base64en = new BASE64Encoder();
                String oldpass1 = base64en.encode(md5.digest(oldpass.getBytes("utf-8")));
                String newpass = base64en.encode(md5.digest(newpass1.getBytes("utf-8")));
                User user1 = userService.testUser(user.getName(),oldpass1);
                if (user1!=null){
                    int re = userService.updatePassword(newpass,user.getId());
                    if (re == 1){
                        msg.setMsg("更新密码成功,密码为:"+newpass1);
                        return msg;
                    }
                }else {
                    msg.setMsg("旧密码错误!请重新输入!");
                    return msg;
                }
            }
            msg.setMsg("更新失败!系统出现错误!请稍后重试!");
            return msg;
        }else{
            msg.setMsg("两次新密码输入不相同!请重新输入!");
            return msg;
        }
    }
    @RequestMapping(value = "/resetPassword")
    @ResponseBody
    public Msg resetPassword(
            @RequestParam("name") String name,
            HttpServletRequest request,
            Msg msg
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        HttpSession session = request.getSession();
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newpass = base64en.encode(md5.digest("123456".getBytes("utf-8")));
        User user = (User) session.getAttribute(TableConstants.USER_SESSION);
        if (user!=null){
            int re = userService.resetPassword(newpass,name);
            if (re == 1){
                msg.setMsg("更新密码成功,密码为:123456");
                return msg;
            }else {
                msg.setMsg("重置失败,请确定用户名是否正确!");
                return msg;
            }
        }else {
            msg.setMsg("系统出现错误!请稍后重试!");
            return msg;
        }
    }

    @RequestMapping(value = "/changeUser")
    @ResponseBody
    public Msg changeUser(
            User user
    ){
        int re = userService.changeUser(user);
        if (re != 0) {
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
    ){
        List<User> users = userService.getUserNameByRiSy(3,0); //此处的系代码需要动态!!!!!
        return Msg.success().add("users",users);
    }

    @RequestMapping(value = "/clearSession")
    public ModelAndView clearSession(
            ModelAndView mv,
            HttpServletRequest request
    ){
        //获取session
        HttpSession session = request.getSession();
        //清除保存内容
        session.removeAttribute("user");
        //销毁该session:清除保存内容与sessionid
        session.invalidate();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public Msg addUser(
            User user
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String password = base64en.encode(md5.digest("123456".getBytes("utf-8")));
        user.setPassword(password);
        int re = userService.addUser(user);
        if (re != 0){
            return Msg.success();
        }
        return Msg.fail();
    }

    @RequestMapping(value = "/removeUser")
    @ResponseBody
    public Msg removeUser(
            @RequestParam("id") int id
    ){
        int re = userService.removeUser(id);
        if (re!=0)
            return Msg.success();
        else
            return Msg.fail();
    }

}
