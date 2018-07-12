package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectByOrderNoAndUserId(@Param(value = "userId")Integer userId, @Param(value = "oderNo") Long orderNo);

    void batchInsertOrderItem(@Param(value = "oderItemList")List orderItemList);

    List<OrderItem> selectByOrderNo(Long orderNo);

}