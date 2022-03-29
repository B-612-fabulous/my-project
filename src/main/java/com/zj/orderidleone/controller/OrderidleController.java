package com.zj.orderidleone.controller;

import com.alibaba.fastjson.JSONObject;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.communityVegetables.service.ICommunityVegetablesService;
import com.zj.config.Result.Result;
import com.zj.login.model.UserBo;
import com.zj.order.model.OrderDetailBo;
import com.zj.order.service.IOrderService;
import com.zj.orderidleone.model.OrderidleBo;
import com.zj.orderidleone.service.IOrderidleService;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping("/order")
public class OrderidleController {
    @Autowired
    private IOrderidleService orderidleService;
    @PostMapping("/order/addOrderidle")
    public Result getUserList(@RequestBody JSONObject param) {
        Result rt = null;
        try {
            rt = orderidleService.addOrderidle(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/getOrderidleList")
    public Result getOrderidleList(@RequestBody OrderidleBo orderidleBo) {
        Result rt = null;
        try {
            rt = orderidleService.getOrderidleList(orderidleBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/deleteOrderidleList")
    public JsonResult<Void> deleteOrderidleList(@RequestBody OrderidleBo orderidleBo) {
        if (orderidleService.deleteorderidle(orderidleBo)) {
            JsonResult jsonResult = new JsonResult();

            jsonResult.setMessage("");
            jsonResult.setState(10000);
            return jsonResult;
        }
        else {
            JsonResult jsonResult = new JsonResult();

            jsonResult.setMessage("");
            jsonResult.setState(10002);
            return jsonResult;
        }

    }
}
