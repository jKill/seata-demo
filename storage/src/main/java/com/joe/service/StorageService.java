package com.joe.service;

public interface StorageService {
    /**
     * deduct storage count
     */
    void deduct(int userId, String commodityCode, int count);
}
