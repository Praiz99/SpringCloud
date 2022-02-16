package com.zeng.store.service;

import com.zeng.store.entity.Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/09/22:23
 * @Description:
 */
public interface IOrderService {
    /**
     *创建订单
     * @param cids 需要购买的购物车列表里的id数组
     * @param uid 用户唯一标识id
     * @param username 用户名
     * @param aid 地址收货信息唯一标识id
     * @return 创建的订单
     */
    Order createOrder(Integer[] cids,Integer uid,String username,Integer aid);
    List<Order> showOrder(Integer uid);
}
