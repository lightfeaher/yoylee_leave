package com.qihang.controller;

import com.qihang.model.System;
import com.qihang.model.User;
import com.qihang.serviceImpl.SystemServiceImpl;
import com.qihang.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SystemController {

    @Autowired
    SystemServiceImpl systemService;

    @RequestMapping(value = "/getSystem")
    @ResponseBody
    public Msg getSystem(){
        List<System> systems = systemService.getSystem();
        return Msg.success().add("systems",systems);
    }
}
