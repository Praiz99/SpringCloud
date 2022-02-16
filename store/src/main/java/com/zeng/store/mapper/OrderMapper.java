package com.zeng.store.mapper;

import com.zeng.store.entity.Order;
import com.zeng.store.entity.OrderItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/09/22:22
 * @Description:
 */
public interface OrderMapper {
    /**
     * 创建订单
     * @param order 订单
     * @return 受影响行数
     */
    Integer createOrder(Order order);

    /**
     * 创建订单商品详情
     * @param orderItem 订单商品详情
     * @return 受影响行数
     */
    Integer createOrderItem(OrderItem orderItem);

    /**
     *
     * @param uid
     * @return
     */
    List<Order> findOrderByUid(Integer uid);
    List<OrderItem> findOrderItemByOid(Integer oid);
}
