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
             ModelAndView mv,
             @RequestParam("num") int num
     ){
         //num参数是区分请求(请假查询1 和  汇总表查询2)
         // 参数:权利标识,系id(中层用,高层查看所有的.高层统一为0,教师统一为-1),登录者id
         List<Leave> leaves = leaveService.getAllLeave("2",3,3);
         mv.addObject("leaves",leaves);
         System.out.println(num);
         if (num==1)
             mv.setViewName("progressQuery");
         else
             mv.setViewName("summarySheet");
         return mv;
     }

     @RequestMapping(value = "/getLeaveByUser")
     public ModelAndView getLeaveByUser(ModelAndView mv){
                 //获得session中user值
         List<Leave> leaves = leaveService.getLeaveByUser("2",0);
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
        //下面的等到session中赋值
        leave.setuId(2);
        leave.setuSys(3);

        leave.setLeader1("1");
        leave.setLeader2("1");
        leave.setSubTime(sqlDate);
        int re = leaveService.addLeave(leave);
        if (re != 0){
            return Msg.success();
        }else
            return Msg.fail();
    }
    /*删*/

    /*改*/
    @RequestMapping(value = "/approveLeave")
    @ResponseBody
    public Msg approveLeave(
            @RequestParam("leaveId") int leaveId,
            @RequestParam("numId") int numId
    ){
        //需要三个参数:请假信息对应的id,是否批准对应的标识,中高层领导标识
        int re = leaveService.approveLeave(leaveId,numId,"2");
        if (re!=0)
            return Msg.success();
        return Msg.fail();
    }

}
