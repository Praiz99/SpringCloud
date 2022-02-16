package com.zeng.store.service.impl;

import com.zeng.store.entity.*;
import com.zeng.store.mapper.CartMapper;
import com.zeng.store.mapper.OrderMapper;
import com.zeng.store.service.IAddressService;
import com.zeng.store.service.ICartService;
import com.zeng.store.service.IOrderService;
import com.zeng.store.service.IProductService;
import com.zeng.store.service.ex.InsertException;
import com.zeng.store.service.util.autoIdGenerator;
import com.zeng.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/09/22:23
 * @Description:
 */
@Service
public class OrderServicelmpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IAddressService iAddressService;
    @Autowired
    private IProductService iProductService;
    @Override
    public Order createOrder(Integer[] cids, Integer uid, String username, Integer aid) {
        //取到即将结算的购物车列表数据
        List<CartVO> cartVOList = iCartService.showCartsByCid(uid,cids);
        long totalPrice=0L;
        for (CartVO cartVO:cartVOList){//计算用户所选中购物车即将下单的商品的总价
            totalPrice+=cartVO.getRealPrice()*cartVO.getNum();
        }
        Date date=new Date();
        Order order=new Order();
        Integer oid = autoIdGenerator.getOrderId();
        order.setOid(oid);
        order.setUid(uid);
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        //订单的收货地址
        Address recAddress = iAddressService.findByAid(aid,uid);
        order.setRecvAddress(recAddress);
        order.setOrderTime(date);
        order.setCreatedUser(username);
        order.setCreatedTime(date);
        order.setModifiedUser(username);
        order.setModifiedTime(date);
        orderMapper.createOrder(order);
        OrderItem orderItem=null;
        Product product=null;
        for (CartVO cartVO:cartVOList){
            orderItem=new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setNum(cartVO.getNum());
            //加入购物车的商品信息
            product=new Product();
            product.setId(cartVO.getPid());
            product.setImage(cartVO.getImage());
            product.setTitle(cartVO.getTitle());
            product.setPrice(cartVO.getRealPrice());
            orderItem.setProduct(product);
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(date);
            orderItem.setModifiedUser(username);
            orderItem.setModifiedTime(date);
            Integer OTResult = orderMapper.createOrderItem(orderItem);
            if (OTResult!=1){
                throw new InsertException("订单插入时出现未知出错");
            }

        }
        return order;
    }

    @Override
    public List<Order> showOrder(Integer uid) {
        List<Order> orders = orderMapper.findOrderByUid(uid);
        for (Order order:orders){
            Integer oid = order.getOid();
            List<OrderItem> orderItems = orderMapper.findOrderItemByOid(oid);
            for (OrderItem orderItem:orderItems){
                Integer pid = orderItem.getProduct().getId();
                Product product = iProductService.findById(pid);
                orderItem.setProduct(product);
            }
            order.setOrderItems(orderItems);
        }
        return orders;
    }
}
