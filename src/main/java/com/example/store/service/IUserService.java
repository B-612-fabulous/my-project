package com.example.store.service;

import com.example.store.entity.User;

public interface IUserService {

    void reg(User user);

    /**
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配用户数据，没有返回null
     */
    User login(String username,String password);
}
