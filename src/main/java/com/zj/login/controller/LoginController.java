package com.zj.login.controller;

import com.zj.CommunityAnnounce.model.CommunityAnnounceBo;
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
    @PostMapping("/getUserList")
    public Result getUserList(@RequestBody UserBo user) {
        Result rt = null;
        try {
            rt = loginService.getUserList(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }



    @PostMapping("/login")
    public Result login(@RequestBody UserBo user, HttpSession session) {
        Result rt = null;
        try {
            rt = loginService.getLogin(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    @PostMapping("/reg")
    public Result reg(@RequestBody UserBo user) {
        Result rt = null;
        // 调用业务对象执行注册
        try {
            rt=loginService.reg(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/deleteUserByid")
    public JsonResult<Void> deleteUserByid(@RequestBody UserBo user) {
        if (loginService.deleteByid(user)) {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setMessage("success");
            jsonResult.setState(10000);
            return jsonResult;
        }
        else {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setMessage("falied");
            jsonResult.setState(10002);
            return jsonResult;
        }

    }
    @PostMapping("/updateByid")
    public JsonResult<Void> updateByid(@RequestBody UserBo user) {
        if (loginService.updateByid(user)) {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setMessage("success");
            jsonResult.setState(10000);
            return jsonResult;
        }
        else {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setMessage("falied");
            jsonResult.setState(10002);
            return jsonResult;
        }

    }

    @PostMapping("/updateByTruename")
    public JsonResult<Void> updateByTruename(@RequestBody UserBo user) {
        if (loginService.updateByUserName(user)) {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setMessage("success");
            jsonResult.setState(10000);
            return jsonResult;
        }
        else {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setMessage("falied");
            jsonResult.setState(10002);
            return jsonResult;
        }

    }
}

