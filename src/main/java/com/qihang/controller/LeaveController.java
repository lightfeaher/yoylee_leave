package com.qihang.controller;

import com.qihang.model.Leave;
import com.qihang.model.User;
import com.qihang.serviceImpl.LeaveServiceImpl;
import com.qihang.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class LeaveController {
    @Autowired
    LeaveServiceImpl leaveService;

     /*查*/
     @RequestMapping(value = "/getAllLeave")
     public ModelAndView getAllLeaveCon(
             ModelAndView mv
     ){
         List<Leave> leaves = leaveService.getAllLeave();
         mv.addObject("leaves",leaves);
         mv.setViewName("success");
         return mv;
     }

     @RequestMapping(value = "/getLeaveByUser")
     public ModelAndView getLeaveByUser(ModelAndView mv){
                 //获得session中user值
         List<Leave> leaves = leaveService.getLeaveByUser("3",1);
         mv.setViewName("approval");
         mv.addObject("leaves",leaves);
         return mv;
     }
    /*增*/

    /**
     * 添加请假信息
     * @param leave 请假对象 在自动赋值时不需要使用@RequestParam注解
     * @return
     */
    @RequestMapping(value = "/addLeave")
    @ResponseBody
    public Msg addLeave(
           Leave leave
    ){
        Date sqlDate = new java.sql.Date(new Date().getTime());
        leave.setLeader1("1");
        leave.setLeader2("2");
        leave.setSubTime(sqlDate);
        int re = leaveService.addLeave(leave);
        if (re != 0){
            return Msg.success();
        }else
            return Msg.fail();
    }
    /*删*/

    /*改*/

}
