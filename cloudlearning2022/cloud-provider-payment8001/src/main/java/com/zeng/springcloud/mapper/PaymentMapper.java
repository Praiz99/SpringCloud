package com.zeng.springcloud.mapper;

import com.zeng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/27/16:25
 * @Description:
 */
@Mapper
public interface PaymentMapper {
    int create(Payment payment);
    Payment findById(@Param("id")Long id);
}
