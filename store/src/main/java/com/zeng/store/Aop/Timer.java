package com.zeng.store.Aop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/13/4:05
 * @Description:
 */

import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class Timer {
    @Around("execution(* com.zeng.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.currentTimeMillis();
        Object result = pjp.proceed();
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        long end=System.currentTimeMillis();
        System.out.println(currentMethod+"耗时:" + (end - start)+"ms" );
        return result;
    }
}
