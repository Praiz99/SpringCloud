package com.zeng.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/15/3:11
 * @Description:
 */
@Controller
@RequestMapping("/error")
public class errorController {
    /**
     * 404页面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "web/404";
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "web/500";
    }
}
