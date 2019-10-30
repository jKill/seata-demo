package com.joe.service;

public interface AccountService {
    /**
     * debit balance of user's account
     */
    void debit(int userId, int money, String commodityCode, int count);
}
