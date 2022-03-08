package com.zj.login.service.impl;

import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.MD5Util;
import com.zj.login.dao.ILoginDao;
import com.zj.login.model.UserBo;
import com.zj.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.UUID;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginDao loginDao;
    @Override
    public Result  getLogin(UserBo user) {//进行登录逻辑处理
        Result rt = new Result();
        try {
//            String passWord = user.getPassWord();
//            String newPwd = MD5Util.string2MD5(passWord);
//            System.out.println(newPwd);
            UserBo loginUser = loginDao.getLogin(user);
            if(loginUser != null){//用户存在,保存session信息
                rt.setCode(GlobalConstant.LOGIN_SUCCESS);
                rt.setData(loginUser);
                rt.setMsg("登录成功");
            }else{//用户不存在，提示用户
                rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
                rt.setMsg("用户名或者密码错误");
            }
            rt.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            e.printStackTrace();
            rt.setState(GlobalConstant.ERROR_STATE);
            rt.setMsg(GlobalConstant.ERROR_COMMON_MSG);
        }
        return rt;
    }



    @Override
    public Result reg(UserBo userBo) {
        Result rt = new Result();
        UserBo userBo1 = selectByusername(userBo);
        if (userBo1 != null) {
            rt.setState(GlobalConstant.ERROR_STATE);
            rt.setMsg("用户名已存在");
        } else{
            try {
                loginDao.insert(userBo);
                rt.setState(GlobalConstant.SUCCE_STATE);
                rt.setMsg("注册成功");
            } catch (Exception e) {
                e.printStackTrace();
                rt.setState(GlobalConstant.ERROR_STATE);
                rt.setMsg("注册失败");
            }
        }
        return rt;
    }

    @Override
    public UserBo selectByusername(UserBo userBo) {
        UserBo userBo1 = loginDao.selectByusername(userBo.getUserName());
        return userBo1;

    }




}
