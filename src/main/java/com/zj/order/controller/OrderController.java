package com.zj.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.zj.config.Result.Result;
import com.zj.login.model.UserBo;
import com.zj.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @PostMapping("/addOrder")
    public Result getUserList(@RequestBody JSONObject param) {
        Result rt = null;
        try {
            rt = orderService.addOrder(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
}
