package com.qihang.service;

import com.qihang.model.User;
import com.qihang.model.User2;

import java.util.List;

public interface UserService {
    List<User2> selectAllUser();
    List<User2> getUserByLike(int sysId,String name);
    User testUser(String name,String pass);
    User getUserById(int id);
    List<User> getUserNameByRiSy(int right, int system);
    int updatePassword(String pass,int id);
    int changeUser(User user);
    int resetPassword(String pass,String name);
    int addUser(User users);
    int removeUser(int id);
}
