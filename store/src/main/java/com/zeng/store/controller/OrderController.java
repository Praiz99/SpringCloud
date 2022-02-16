package com.zeng.store.controller;

import com.zeng.store.entity.Order;
import com.zeng.store.service.IOrderService;
import com.zeng.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/09/22:22
 * @Description:
 */
@RestController
@RequestMapping("orders")
public class OrderController extends  BaseController{
    @Autowired
    private IOrderService iOrderService;
    @RequestMapping("create")
    public JsonResult<Order> createOrders(HttpSession httpSession,Integer[] cids,Integer aid){
        Order order = iOrderService.createOrder(cids,
                getuidFromSession(httpSession),
                getUsernameFromSession(httpSession),
                aid);
        return new JsonResult<Order>(OK,order);
    }
    @RequestMapping("show")
    public JsonResult<List<Order>> showOrder(HttpSession httpSession){
        List<Order> orders = iOrderService.showOrder(getuidFromSession(httpSession));
        return new JsonResult<>(OK,orders);
    }
}
