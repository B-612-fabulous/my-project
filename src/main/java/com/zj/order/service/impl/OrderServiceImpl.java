package com.zj.order.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import com.zj.order.dao.IOrderDao;
import com.zj.order.model.OrderDetailBo;
import com.zj.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Override
    @Transactional
    public Result addOrder(JSONObject param) {
        Result rt = new Result();
        try {
            //1.新增订单主表信息
            Map<String,Object> orderMap = new HashMap<>();
            String orderId = UuidUtil.newGeneratId();
            orderMap.put("id", orderId);//主键ID
            orderMap.put("createPeople",param.getString("userId"));//创建人
            orderMap.put("sendAddr",param.getString("sendAddr"));//配送地址
            orderMap.put("orderState",1);//订单状态 1.捡货中 2.配送中 3.已取消 4.已完成
            orderMap.put("isEvaluate",0);//是否评价1.已经评价 0 未评价
            orderMap.put("isDelete",0);//是否删除1.已经删除 0 未删除
            orderMap.put("createDate", TimeUtil.getDateTime());//创建时间
            orderDao.addOrder(orderMap);
            JSONArray orderList = param.getJSONArray("orderList");
            List<Map<String,Object>> orderDetailList = new ArrayList<Map<String,Object>>();
            for (Object o : orderList) {
                Map<String,Object> orderDetailMap = new HashMap<>();
                JSONObject jo = (JSONObject) o;
                orderDetailMap.put("id",UuidUtil.newGeneratId());
                orderDetailMap.put("orderId",orderId);
                orderDetailMap.put("price",jo.getString("price"));
                orderDetailMap.put("cartNumber",jo.getIntValue("cartNumber"));
                orderDetailMap.put("fmImg",jo.getString("fmImg"));
                orderDetailMap.put("preferentialRules",jo.getString("preferentialRules"));
                orderDetailMap.put("commodityDesc",jo.getString("commodityDesc"));
                orderDetailMap.put("isSeckill",jo.getBooleanValue("seckill"));
                orderDetailMap.put("title",jo.getString("title"));
                orderDetailMap.put("vegetablesId",jo.getString("id"));
                orderDetailMap.put("createPeople",param.getString("userId"));
                orderDetailMap.put("createDate", TimeUtil.getDateTime());//创建时间
                orderDetailMap.put("isDelete",0);//是否删除1.已经删除 0 未删除
                orderDetailList.add(orderDetailMap);
            }
            orderDao.addOrderDetail(orderDetailList);
            rt.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            e.printStackTrace();
            rt.setState(GlobalConstant.ERROR_STATE);
        }
        return rt;
    }

    @Override
    public Result getOrderDetailList(OrderDetailBo orderDetailBo) {

      Result r = new Result();
       try {
          List<OrderDetailBo> odList = orderDao.getOrderDetailList(orderDetailBo);
            r.setState(GlobalConstant.SUCCE_STATE);
           r.setData(odList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Boolean deleteorderid(OrderDetailBo orderDetailBo) {
        Integer rows = orderDao.deleteorderid(orderDetailBo);
        if (rows==1){
            return true;
        }
        else {
            return false;
        }
    }
}
