package com.zeng.store.service;

import com.zeng.store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/13/23:16
 * @Description:
 */
@SpringBootTest
//@RunWith：表示这个单元测试类（单元测试类是不能够运行的）,需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Autowired
    IOrderService iOrderService;
    @Test
    public void showOrder(){
        List<Order> orders = iOrderService.showOrder(17);
        System.out.println(orders);
    }
}
