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
    public Boolean reg(UserBo userBo) {
        Result rt = new Result();

//        String username = userBo.getUserName();
//        String passWord = userBo.getPassWord();
//        user.setUserName(username);
//        user.setPassWord(passWord);

//        String salt = UUID.randomUUID().toString().toUpperCase();
//        String md5Password = getMd5PassWord(user.getPassWord(), salt);
//        user.setPassWord(password);
        UserBo userBo1 = selectByusername(userBo);
        if (userBo1 != null) {

//            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
//            System.out.println("尝试注册的用户名[" + username + "]已经被占用");
            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名已存在");
            return false;

        } else{
            Integer rows = loginDao.insert(userBo);
            return true;
        }




    }

    @Override
    public UserBo selectByusername(UserBo userBo) {
        UserBo userBo1 = loginDao.selectByusername(userBo.getUserName());
        return userBo1;

    }




}
