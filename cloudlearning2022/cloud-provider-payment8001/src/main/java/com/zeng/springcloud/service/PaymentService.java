package com.zeng.springcloud.service;

import com.zeng.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/27/16:51
 * @Description:
 */
public interface PaymentService {
    int create(Payment payment);
    Payment findById(Long id);
}
