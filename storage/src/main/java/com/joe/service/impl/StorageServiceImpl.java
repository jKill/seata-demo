package com.joe.service.impl;

import com.joe.dao.CommodityMapper;
import com.joe.entity.AccountReqDTO;
import com.joe.manager.AccountManager;
import com.joe.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("storageService")
public class StorageServiceImpl implements StorageService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private AccountManager accountManager;

    @GlobalTransactional
    @Override
    public void deduct(int userId, String commodityCode, int count) {
        // 减库存
        commodityMapper.deduteByCommodityCode(commodityCode, count);
        // 计算总价
        int price = Integer.valueOf(commodityCode.split("_")[1]);
        System.out.println(commodityCode + "的单价：" + count);
        int money = price * count;

        AccountReqDTO accountReqDTO = new AccountReqDTO();
        // for account business
        accountReqDTO.setMoney(money);
        accountReqDTO.setUserId(userId);
        // for order business
        accountReqDTO.setCommodityCode(commodityCode);
        accountReqDTO.setCount(count);
        accountManager.deductAccount(accountReqDTO);
    }
}
