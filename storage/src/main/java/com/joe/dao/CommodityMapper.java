package com.joe.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommodityMapper {

    int deduteByCommodityCode(@Param("commodityCode") String commodityCode, @Param("count") int count);
}