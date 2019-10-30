package com.joe.dao;

import com.joe.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insert(Order order);
}
