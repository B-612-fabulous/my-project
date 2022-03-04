package com.zj.login.service;

import com.zj.login.model.UserBo;

public interface ILoginService {

    void getLogin(UserBo user);

    void reg(UserBo user);


}
