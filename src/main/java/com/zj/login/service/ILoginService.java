package com.zj.login.service;

import com.zj.config.Result.Result;
import com.zj.login.model.UserBo;

public interface ILoginService {

    Result  getLogin(UserBo user);

    Boolean reg(UserBo user);

    UserBo selectByusername(UserBo userBo);


}
