package com.qihang.service;

import com.qihang.model.User;

import java.util.List;

public interface UserService {

    List<User> GetUserNameByRiSy(int right, int system);
}
