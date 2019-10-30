package com.joe.controller;

import com.alibaba.fastjson.JSONObject;
import com.joe.entity.OrderDTO;
import com.joe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        System.out.println("order接受account请求，入参打印：" + JSONObject.toJSON(orderDTO));
        int userId = orderDTO.getUserId();
        String commodityCode = orderDTO.getCommodityCode();
        int count = orderDTO.getCount();
        // 创订单
        orderService.create(userId, commodityCode, count);
    }
}
