package com.zj.order.dao;


import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.order.model.OrderDetailBo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IOrderDao {
    void addOrder(Map<String, Object> orderMap);

    void addOrderDetail(List<Map<String, Object>> orderDetailList);

//    void getOrderDetailList(List<Map<String, Object>> getOrderDetailList);
    List<OrderDetailBo> getOrderDetailList( OrderDetailBo orderDetailBo);
    Integer deleteorderid(OrderDetailBo orderDetailBo);

}
