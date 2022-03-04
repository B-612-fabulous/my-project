package com.zj.login.controller;

import com.zj.config.Result.Result;
import com.zj.login.model.UserBo;
import com.zj.login.service.ILoginService;
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
        return new Result(200);
    }
}

