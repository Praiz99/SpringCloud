package com.zeng.store.config;

import com.zeng.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/31/13:14
 * @Description:
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor loginInterceptor = new LoginInterceptor();
        List<String> excludepath=new ArrayList<>();
        excludepath.add("/bootstrap3/**");
        excludepath.add("/css/**");
        excludepath.add("/images/**");
        excludepath.add("/js/**");
        excludepath.add("/web/login.html");
        excludepath.add("/web/register.html");
        excludepath.add("/web/product.html");
        excludepath.add("/web/index.html");
        excludepath.add("/users/reg");
        excludepath.add("/users/login");
        excludepath.add("/products/**");
        excludepath.add("/proCategories/show");
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").
                excludePathPatterns(excludepath);
    }
}
