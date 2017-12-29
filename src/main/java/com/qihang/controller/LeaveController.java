package com.qihang.controller;

import com.qihang.model.Leave;
import com.qihang.serviceImpl.LeaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LeaveController {
    @Autowired
    LeaveServiceImpl leaveService;

    @RequestMapping(value = "/getAllLeave")
    public ModelAndView GetAllLeaveCon(
            ModelAndView mv
    ){
        List<Leave> leaves = leaveService.GetAllLeave();
        mv.addObject("leaves",leaves);
        mv.setViewName("success");
        return mv;
    }

}
