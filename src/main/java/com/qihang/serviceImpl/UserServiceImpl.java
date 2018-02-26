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


    public User testUser(String name, String pass) {
        return userDao.testUser(name,pass);
    }

    public List<User> getUserNameByRiSy(int right, int system) {
        return  userDao.SelectUserByRiSy(right,system);
    }

    public int updatePassword(String pass, int id) {
        return userDao.updatePassword(pass,id);
    }
}
