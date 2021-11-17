package com.example.store.controller;

import com.example.store.service.ex.*;
import com.example.store.service.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

//控制层控制基类
public class BaseController {

    public static final int OK=200;
    @ExceptionHandler(ServiceException.class)

    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessageg("用户名已经被占用");
        }

        else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessageg("用户不存在异常");
        }
        else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessageg("用户密码异常");
        }


        else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessageg("用户注册产生未知异常");
        }

        return result;
    }

    protected final  Integer getUidFromSession(HttpSession session){

        return   Integer .valueOf(session.getAttribute("uid").toString());
    }
    protected final   String getUsernameFromSession(HttpSession session){

        return session.getAttribute("username").toString();
    }
}
