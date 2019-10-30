package com.joe.manager;

import com.joe.entity.OrderReqDTO;
import com.joe.entity.RpcResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order")
public interface OrderManager {

    /**
     * 创建订单
     * @param orderReqDTO
     * @return
     */
    @PostMapping("/order/create")
    RpcResponse<Object> createOrder(@RequestBody OrderReqDTO orderReqDTO);
}
