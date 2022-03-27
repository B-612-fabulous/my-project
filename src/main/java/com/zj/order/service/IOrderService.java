package com.zj.order.service;

import com.alibaba.fastjson.JSONObject;
import com.zj.config.Result.Result;

public interface IOrderService {
    Result addOrder(JSONObject param);
}
