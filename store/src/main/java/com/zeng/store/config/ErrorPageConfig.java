package com.zeng.store.config;


import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/15/3:08
 * @Description:
 */
@Configuration
public class ErrorPageConfig  {
     @Bean
     public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
                 WebServerFactoryCustomizer<ConfigurableWebServerFactory> customizer = new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
                     @Override
                    public void customize(ConfigurableWebServerFactory factory) {
                         // 定义404错误页
                                 HttpStatus notFound = HttpStatus.NOT_FOUND;
                                 System.out.println(notFound);
                                // 定义404错误页
                                ErrorPage errorPage404 = new ErrorPage(notFound, "/web/404.html");
                                 ErrorPage errorPage500 = new ErrorPage(notFound, "/web/500.html");
                                 // 追加错误页，替换springboot默认的错误页
                                factory.addErrorPages(errorPage404);
                               // 设置tomcat服务器的端口号
                               factory.setPort(8080);
                             }

                 };
               return customizer;
            }

}
