package com.zj.orderidleone.service.impl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import com.zj.order.model.OrderDetailBo;
import com.zj.orderidleone.dao.IOrderidleDao;
import com.zj.orderidleone.model.OrderidleBo;
import com.zj.orderidleone.service.IOrderidleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("OrderidleService")
public class OrderidleServiceImpl implements IOrderidleService {
    @Autowired
    private IOrderidleDao orderidleDao;
    @Override
    @Transactional
    public Result addOrderidle(JSONObject param) {
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
            orderidleDao.addOrderidle(orderMap);
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
                orderDetailMap.put("commodityDesc",jo.getString("commodityDesc"));
                orderDetailMap.put("idlezonId",jo.getString("id"));
                orderDetailMap.put("createPeople",param.getString("userId"));
                orderDetailMap.put("createDate", TimeUtil.getDateTime());//创建时间
                orderDetailMap.put("isDelete",0);//是否删除1.已经删除 0 未删除
                orderDetailList.add(orderDetailMap);
            }
            orderidleDao.addOrderDetailidle(orderDetailList);
            rt.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            e.printStackTrace();
            rt.setState(GlobalConstant.ERROR_STATE);
        }
        return rt;
    }

    @Override
    public Result getOrderidleList(OrderidleBo orderidleBo) {

      Result r = new Result();
       try {
          List<OrderDetailBo> odList = orderidleDao.getOrderDetailList(orderidleBo);
            r.setState(GlobalConstant.SUCCE_STATE);
           r.setData(odList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }
//
    @Override
    public Boolean deleteorderidle(OrderidleBo orderidleBo) {
        Integer rows = orderidleDao.deleteorderidle(orderidleBo);
        if (rows==1){
            return true;
        }
        else {
            return false;
        }
    }
}
