package com.joe.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    int deduteByUserId(Integer userId, Integer money);
}