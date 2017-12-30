package com.qihang.serviceImpl;

import com.qihang.dao.UserDao;
import com.qihang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserDao userDao;


    public String[] GetUserNameByRiSy(int right,int system) {
        return  userDao.SelectUserByRiSy(right,system);
    }
}
