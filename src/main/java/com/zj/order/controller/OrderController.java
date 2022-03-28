package com.zj.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.communityVegetables.service.ICommunityVegetablesService;
import com.zj.config.Result.Result;
import com.zj.login.model.UserBo;
import com.zj.order.model.OrderDetailBo;
import com.zj.order.service.IOrderService;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping("/order")
public class OrderController {
//    @Autowired
//    private IOrderService orderService ;
    @Autowired
    private IOrderService orderService;
    @PostMapping("/order/addOrder")
    public Result getUserList(@RequestBody JSONObject param) {
        Result rt = null;
        try {
            rt = orderService.addOrder(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/getOrderDetailList")
    public Result getOrderDetailList(@RequestBody OrderDetailBo orderDetailBo) {
        Result rt = null;
        try {
            rt = orderService.getOrderDetailList(orderDetailBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/deleteOrderDetailList")
    public JsonResult<Void> deleteOrderDetailList(@RequestBody OrderDetailBo orderDetailBo) {
        if (orderService.deleteorderid(orderDetailBo)) {
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
