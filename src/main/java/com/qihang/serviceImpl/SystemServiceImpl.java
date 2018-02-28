package com.qihang.serviceImpl;

import com.qihang.dao.SystemDao;
import com.qihang.model.System;
import com.qihang.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemDao systemDao;

    public List<System> getSystem() {
        return systemDao.selectSystem();
    }
}
