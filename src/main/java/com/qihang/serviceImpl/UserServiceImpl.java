package com.qihang.serviceImpl;

import com.qihang.dao.UserDao;
import com.qihang.model.User;
import com.qihang.model.User2;
import com.qihang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserDao userDao;


    public List<User2> selectAllUser() {
        return userDao.selectAllUser();
    }

    public List<User2> getUserByLike(int sysId, String name) {
        return userDao.selectUserByLike(sysId,name);
    }

    public User testUser(String name, String pass) {
        return userDao.testUser(name,pass);
    }

    public User getUserById(int id) {
        return userDao.selectUserById(id);
    }

    public List<User> getUserNameByRiSy(int right, int system) {
        return  userDao.SelectUserByRiSy(right,system);
    }

    public int updatePassword(String pass, int id) {
        return userDao.updatePassword(pass,id);
    }

    public int changeUser(User user) {
        return userDao.updateUser(user);
    }

    public int resetPassword(String pass, String name) {
        return userDao.resetPassword(pass,name);
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    public int removeUser(int id) {
        return userDao.deleteUser(id);
    }
}
