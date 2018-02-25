package com.qihang.service;

import com.qihang.model.User;

import java.util.List;

public interface UserService {
    User testUser(String name,String pass);
    List<User> getUserNameByRiSy(int right, int system);
}
