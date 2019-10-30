package com.joe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.joe.dao.AccountMapper;
import com.joe.entity.OrderReqDTO;
import com.joe.manager.OrderManager;
import com.joe.service.AccountService;
import io.seata.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private OrderManager orderManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void debit(int userId, int money, String commodityCode, int count) {
        // account business
        accountMapper.deduteByUserId(userId, money);
        // order business
        OrderReqDTO orderReqDTO = new OrderReqDTO();
        orderReqDTO.setUserId(userId);
        orderReqDTO.setCommodityCode(commodityCode);
        orderReqDTO.setCount(count);
        orderManager.createOrder(orderReqDTO);
    }
}
