package com.zj.order.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IOrderDao {
    void addOrder(Map<String, Object> orderMap);

    void addOrderDetail(List<Map<String, Object>> orderDetailList);
}
