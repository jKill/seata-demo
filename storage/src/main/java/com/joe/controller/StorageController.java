package com.joe.controller;

import com.joe.entity.PurchaseDTO;
import com.joe.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/storage")
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/purchase")
    public void purchase(@RequestBody PurchaseDTO purchaseDTO) {

        int userId = purchaseDTO.getUserId();
        String commodityCode = purchaseDTO.getCommodityCode();
        int count = purchaseDTO.getCount();
        // 扣库存，创订单
        storageService.deduct(userId, commodityCode, count);
    }
}
