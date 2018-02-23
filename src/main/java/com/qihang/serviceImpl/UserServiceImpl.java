package com.qihang.serviceImpl;

import com.qihang.dao.UserDao;
import com.qihang.model.User;
import com.qihang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserDao userDao;


    public List<User> GetUserNameByRiSy(int right, int system) {
        return  userDao.SelectUserByRiSy(right,system);
    }
}
