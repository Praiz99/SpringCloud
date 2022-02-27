package com.zeng.springcloud.service.impl;

import com.zeng.springcloud.entities.Payment;
import com.zeng.springcloud.mapper.PaymentMapper;
import com.zeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/27/16:53
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);

    }

    @Override
    public Payment findById(Long id) {
        return paymentMapper.findById(id);
    }
}
