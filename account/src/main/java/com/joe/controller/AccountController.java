package com.joe.controller;

import com.joe.entity.Account;
import com.joe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deduct")
    public void deductAccount(@RequestBody Account account) {

        int userId = account.getUserId();
        int money = account.getMoney();
        // for order business
        String commodityCode = account.getCommodityCode();
        int count = account.getCount();
        // 扣库存，创订单
        accountService.debit(userId, money, commodityCode, count);
    }
}
