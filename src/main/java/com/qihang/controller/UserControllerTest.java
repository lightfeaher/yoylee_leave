package com.qihang.controller;


import com.qihang.models.Teacher;
import com.qihang.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserControllerTest {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/abc" ,method = RequestMethod.POST)
    public ModelAndView login1(
            @RequestParam("name") String name,
            //HttpServletResponse response,
           // HttpServletRequest request,
            ModelAndView mv){

      /*  //cookie测试
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies){
            System.out.println(c.getName());
            System.out.println("  ");
        }
        //session测试
        String sessionid = request.getSession().getId();
        System.out.println(sessionid);
        Cookie cookie = new Cookie("yangyang",sessionid);
        cookie.setMaxAge(30);
        response.addCookie(cookie);*/

        Teacher teacher = userService.getInfo(name);
        mv.addObject("teacher",teacher);
        mv.setViewName("/test");
        return mv;
    }


    @RequestMapping(value = "/abc",method = RequestMethod.DELETE)
    @ResponseBody  //使用rest风格必须添加该注解   不添加该注解会将返回值作为jsp接口,通过视图解析器寻找jsp页面  添加后为返回数据
    public String login2(){
        return "调用了delete方法";
    }


    @RequestMapping(value = "/abc",method = RequestMethod.PUT)
    @ResponseBody
    public String login3(){
        return "调用了put方法";
    }
    @RequestMapping(value = "/abc",method = RequestMethod.GET)
    @ResponseBody
    public String login4(){
        return "调用了get方法";
    }
}
