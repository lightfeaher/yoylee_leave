package com.qihang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qihang.model.Leave;
import com.qihang.model.LeaveDetail;
import com.qihang.model.User;
import com.qihang.serviceImpl.LeaveServiceImpl;
import com.qihang.util.Msg;
import com.qihang.util.TableConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class LeaveController {

    @Autowired
    LeaveServiceImpl leaveService;

     /*查*/
     @RequestMapping(value = "/getQueryLeave")
     @ResponseBody
     public Msg getQueryLeave(
             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
             HttpServletRequest request
     ){
         //获取session
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute(TableConstants.USER_SESSION);

         //num参数是区分请求(请假查询1 和  汇总表查询2)
         // 参数:权利标识,系id(中层用,高层查看所有的.高层统一为0,教师统一为-1),登录者id
         PageHelper.startPage(pn, 5);
         // startPage后面紧跟的这个查询就是一个分页查询
         List<Leave> leaves = leaveService.getAllLeave("1",-1,user.getId());  //!!!只需要userID为动态
         // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
         // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数7
         PageInfo pageInfo = new PageInfo(leaves, 7);
         return Msg.success().add("pageInfo",pageInfo);
     }
     @RequestMapping(value = "/getAllLeave")
     @ResponseBody
     public Msg getAllLeave(
             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
             HttpServletRequest request
     ){
         //获取session
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute(TableConstants.USER_SESSION);

         //num参数是区分请求(请假查询1 和  汇总表查询2)
         // 参数:权利标识,系id(中层用,高层查看所有的.高层统一为0,教师统一为-1),登录者id
         PageHelper.startPage(pn, 7);
         // startPage后面紧跟的这个查询就是一个分页查询
         List<Leave> leaves = leaveService.getAllLeave(user.getPower(),Integer.valueOf(user.getSystem()),user.getId()); //!!这个地方  需要所有的动态
         // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
         // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数7
         PageInfo pageInfo = new PageInfo(leaves, 7);
         return Msg.success().add("pageInfo",pageInfo);
     }
     @RequestMapping(value = "/getLeaveByLike")
     @ResponseBody
     public Msg getLeaveByLike(
             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
             @RequestParam("orApprove") int orApprove,
             @RequestParam("systemId") int systemId,
             @RequestParam("nameId") String name,
             HttpServletRequest request
     ){
         //获取session
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute(TableConstants.USER_SESSION);

         //num参数是区分请求(请假查询1 和  汇总表查询2)
         // 参数:权利标识,系id(中层用,高层查看所有的.高层统一为0,教师统一为-1),登录者id
         PageHelper.startPage(pn, 7);
         // startPage后面紧跟的这个查询就是一个分页查询
         List<Leave> leaves = leaveService.getLeaveByLike(orApprove,systemId,name,user.getPower(),Integer.valueOf(user.getSystem()),user.getId()); //!!这个地方  需要所有的动态
         // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
         // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数7
         PageInfo pageInfo = new PageInfo(leaves, 7);
         return Msg.success().add("pageInfo",pageInfo);
     }

//     @RequestMapping(value = "/getQueryLeave")
//     public ModelAndView getQueryLeave(
//             ModelAndView mv
//     ){
//         List<Leave> leaves = leaveService
//     }

     @RequestMapping(value = "/getLeaveByUser")
     public ModelAndView getLeaveByUser(
             ModelAndView mv,
             HttpServletRequest request
     ){
         //获得session中user值
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute(TableConstants.USER_SESSION);

         List<Leave> leaves = new ArrayList<Leave>();
         if (user!=null){
             if (Integer.valueOf(user.getPower())==2 ||Integer.valueOf(user.getPower())==4)
                 leaves = leaveService.getLeaveByUser(String.valueOf(user.getId()),0);
             if (Integer.valueOf(user.getPower())==3)
                 leaves = leaveService.getLeaveByUser(String.valueOf(user.getId()),1);
             if (Integer.valueOf(user.getPower())==1)
                 leaves = null;

         }
         mv.setViewName("approval");
         mv.addObject("leaves",leaves);
         return mv;
     }

     @RequestMapping(value = "/getSingleLeave/{id}")
     @ResponseBody
     public Msg getSingleLeave(
             @PathVariable("id") int id
     ){
        LeaveDetail leave = leaveService.getSingleLeave(id);
         return Msg.success().add("singleLeave",leave);
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
            Leave leave,
            HttpServletRequest request
    ){
        //获得session中user值
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(TableConstants.USER_SESSION);

        Date sqlDate = new java.sql.Date(new Date().getTime());
        //下面的等到session中赋值
        leave.setuId(user.getId());
        leave.setuSys(Integer.valueOf(user.getSystem()));

        leave.setLeader1("1");
        leave.setLeader2("1");
        leave.setSubTime(sqlDate);
        int re = leaveService.addLeave(leave);
        if (re != 0){
            return Msg.success();
        }else
            return Msg.fail();
    }
    @RequestMapping(value = "/getPrivateLeave")
    public ModelAndView getPrivateLeave(
            ModelAndView mv,
            HttpServletRequest request
    ){
        //获得session中user值
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(TableConstants.USER_SESSION);

        //获得登录者的id
        List<Leave> leaves = leaveService.getPrivateLeave(user.getId());
        mv.addObject("leaves",leaves);
        mv.setViewName("revoke");
        return mv;
    }
    /*删*/

    @RequestMapping(value = "/revokeLeave")
    @ResponseBody
    public Msg revokeLeave(
            @RequestParam("delId") int delId
    ){
        int re = leaveService.removeLeave(delId);
        if (re != 0){
            return Msg.success();
        }
        return Msg.fail();
    }

    /*改*/
    @RequestMapping(value = "/approveLeave")
    @ResponseBody
    public Msg approveLeave(
            @RequestParam("leaveId") int leaveId,
            @RequestParam("numId") int numId,
            HttpServletRequest request
    ){
        //获得session中user值
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(TableConstants.USER_SESSION);

        //需要三个参数:请假信息对应的id,是否批准对应的标识,中高层领导标识
        int re = leaveService.approveLeave(leaveId,numId,user.getPower());
        if (re!=0)
            return Msg.success();
        return Msg.fail();
    }

}
