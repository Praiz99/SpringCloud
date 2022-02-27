package com.zeng.springcloud.controller;

import com.zeng.springcloud.entities.JsonResult;
import com.zeng.springcloud.entities.Payment;
import com.zeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/27/16:23
 * @Description:
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("create")
    public JsonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***插入的结果"+result);
        if (result>0){
            return new JsonResult<>(200,"插入成功",result);
        }else {
            return new JsonResult<>(400,"插入失败");
        }

    }
    @GetMapping("findById/{id}")
    public JsonResult<Payment> findById(@PathVariable Long id){
        Payment payment = paymentService.findById(id);
        log.info("***查询的结果"+payment);
        if (payment!=null){
            return new JsonResult<>(200,"查询成功",payment);
        }else {
            return new JsonResult<>(400,"未查询到数据");
        }
    }
}
