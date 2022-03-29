package com.zj.orderidleone.dao;


import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.order.model.OrderDetailBo;
import com.zj.orderidleone.model.OrderidleBo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IOrderidleDao {
    void addOrderidle(Map<String, Object> orderMap);

    void addOrderDetailidle(List<Map<String, Object>> orderDetailList);

//    void getOrderDetailList(List<Map<String, Object>> getOrderDetailList);
    List<OrderDetailBo> getOrderDetailList( OrderidleBo orderidleBo);
    Integer deleteorderidle(OrderidleBo orderidleBo);

}
