package com.zj.order.service;

import com.alibaba.fastjson.JSONObject;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.config.Result.Result;
import com.zj.order.model.OrderDetailBo;

public interface IOrderService {
    Result addOrder(JSONObject param);
    Result getOrderDetailList(OrderDetailBo   orderDetailBo);
    Boolean deleteorderid(OrderDetailBo   orderDetailBo);
}
