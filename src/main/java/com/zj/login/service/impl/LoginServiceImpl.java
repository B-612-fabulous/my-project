package com.zj.login.service.impl;

import com.zj.login.dao.ILoginDao;
import com.zj.login.model.UserBo;
import com.zj.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginDao loginDao;
    @Override
    public void getLogin(UserBo user) {//进行登录逻辑处理
        UserBo loginUser = loginDao.getLogin(user);
        if(loginUser != null){

        }
    }
}
