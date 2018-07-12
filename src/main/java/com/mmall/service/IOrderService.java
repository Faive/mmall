package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**
 * @author YH
 */


public interface IOrderService {
    ServerResponse create(Integer userId, Integer shippingId);

    ServerResponse<String> cancel(Integer userId, long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> detail(Integer userId, long orderNo);

    ServerResponse getOrderList(Integer userId, int pageNum, int pageSize);

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse alipayCallback(Map<String, String> paramsMap);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    //backend
    ServerResponse manageList(int pageNum, int pageSize);

    ServerResponse manageDetail(long orderNo);

    ServerResponse manageSearch(long orderNo, int pageNum, int pageSize);

    ServerResponse<String> orderSendGoods(long orderNo);
}
