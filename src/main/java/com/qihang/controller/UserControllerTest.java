package com.qihang.controller;


import com.qihang.models.Teacher;
import com.qihang.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControllerTest {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/abc")
    public ModelAndView login(
            @RequestParam("name") String name,
            ModelAndView mv){
        Teacher teacher = userService.getInfo(name);
        mv.addObject("teacher",teacher);
        mv.setViewName("/test");
        return mv;
    }
}
