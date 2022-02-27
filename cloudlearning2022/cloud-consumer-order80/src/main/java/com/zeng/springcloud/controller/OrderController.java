package com.zeng.springcloud.controller;

import com.zeng.springcloud.entities.JsonResult;
import com.zeng.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/27/20:58
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {
    private static final String PAYMENT_URL="http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("payment/create")
    public JsonResult<Integer> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,JsonResult.class);
    }
    @GetMapping("payment/get/{id}")
    public JsonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/findById/"+id,JsonResult.class);
    }
}
