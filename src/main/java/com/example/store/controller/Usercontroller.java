package com.example.store.controller;

import com.example.store.entity.User;
import com.example.store.service.IUserService;
import com.example.store.service.ex.InsertException;
import com.example.store.service.ex.UsernameDuplicatedException;
import com.example.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//@Controller
@RestController
@RequestMapping("users")
public class Usercontroller extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")

    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);


    }
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data=userService.login(username,password);
        // session.setAttribute("uid",data.getUid());
        // session.setAttribute("username",data.getUsername());
        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        System.out.println("Session中的uid=" + getUidFromSession(session));
        System.out.println("Session中的username=" + getUsernameFromSession(session));


        return new  JsonResult<User>(OK,data);

    }

}
