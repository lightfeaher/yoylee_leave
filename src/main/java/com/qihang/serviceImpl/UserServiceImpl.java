package com.qihang.serviceImpl;

import com.qihang.dao.UserTest;
import com.qihang.models.Teacher;
import com.qihang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserTest userTest;

    public Teacher getInfo(String name) {
        return userTest.selectByLoginnameAndPassword(name);

    }
    public int getInfo1(String name) {
        return userTest.deleteByLoginnameAndPassword(name);

    }
}
