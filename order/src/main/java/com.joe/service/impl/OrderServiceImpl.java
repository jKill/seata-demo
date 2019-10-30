package com.joe.service.impl;

import com.joe.dao.OrderMapper;
import com.joe.entity.Order;
import com.joe.service.OrderService;
import io.seata.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public Integer create(int userId, String commodityCode, int orderCount) {

//        if (StringUtils.isNotBlank(commodityCode)) {
//            throw new RuntimeException("exception to test Global Transcation");
//        }
        // 总价
        int orderMoney = calculate(commodityCode, orderCount);

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);

        // INSERT INTO orders ...
        return orderMapper.insert(order);
    }

    /**
     * 计算金额
     *
     * @param commodityCode
     * @param orderCount
     * @return
     */
    private int calculate(String commodityCode, int orderCount) {
        String priceStr = commodityCode.split("_")[1];
        System.out.println("单价：" + priceStr);
        int price = Integer.valueOf(priceStr);
        return price * orderCount;
    }

}
