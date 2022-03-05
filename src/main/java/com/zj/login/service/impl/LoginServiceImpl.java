package com.zj.login.service.impl;

import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.MD5Util;
import com.zj.login.dao.ILoginDao;
import com.zj.login.model.UserBo;
import com.zj.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void reg(UserBo user) {

        String username = user.getUserName();
//        String salt = UUID.randomUUID().toString().toUpperCase();
//        String md5Password = getMd5PassWord(user.getPassWord(), salt);
//        user.setPassWord(password);
        // 调用持久层的User findByUsername(String username)方法，根据用户名查询用户数据

        // 判断查询结果是否不为null
//        if (result != null) {
//             是：表示用户名已被占用，则抛出UsernameDuplicateException异常
//            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
//            System.out.println("尝试注册的用户名[" + username + "]已经被占用");
        Integer rows = loginDao.insert(user);

        }

}
