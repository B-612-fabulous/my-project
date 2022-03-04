package com.zj.login.controller;

import com.zj.config.Result.Result;
import com.zj.login.model.UserBo;
import com.zj.login.service.ILoginService;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private ILoginService loginService = null;
    @PostMapping("/login")
    public Result login(@RequestBody UserBo user, HttpSession session) {
        loginService.getLogin(user);

//        return new Result(200);
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
    @PostMapping("/reg")
    public JsonResult<Void> reg(UserBo user) {
        // 调用业务对象执行注册
        loginService.reg(user);
        // 返回
        return new JsonResult<Void>(200);
    }
}

