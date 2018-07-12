package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectByProductIdAndUserId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    List<Cart> selectByUserId(Integer userId);

    int selectCartProductCheckStatusByUserId(Integer userId);

    int deleteByUserIdAndProducts(@Param("userId") Integer userId,@Param("productIdList") List<String> productIdList);

    int checkedOrUnchecked(@Param("userId") Integer userId,@Param("productId") Integer productId,@Param("checked") Integer checked);

    int selectCartProductCount(Integer userId);

    List<Cart> selectCheckedCart(Integer userId);
}