package com.joe.service;

public interface OrderService {
    /**
     * create order
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return 订单总金额
     */
    Integer create(int userId, String commodityCode, int orderCount);
}
