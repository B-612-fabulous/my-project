package com.zj.login.service.impl;

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
    public void getLogin(UserBo user) {//进行登录逻辑处理
        UserBo loginUser = loginDao.getLogin(user);
        if(loginUser != null){

        }
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
