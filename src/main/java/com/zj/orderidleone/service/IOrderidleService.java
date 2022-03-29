package com.zj.orderidleone.service;
import com.alibaba.fastjson.JSONObject;
import com.zj.config.Result.Result;
import com.zj.orderidleone.model.OrderidleBo;


public interface IOrderidleService {
    Result addOrderidle(JSONObject param);
    Result getOrderidleList(OrderidleBo orderidleBo);
    Boolean deleteorderidle(OrderidleBo orderidleBo);
}
