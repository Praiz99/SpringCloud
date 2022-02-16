package com.zeng.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;
import java.util.Date;

@SpringBootApplication
@MapperScan("com.zeng.store.mapper")
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
    @Bean
    public MultipartConfigElement  getMultipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        //设置文件大小10MB
        factory.setMaxFileSize(DataSize.of(10,DataUnit.MEGABYTES));
        //设置上传的总数据10MB
        factory.setMaxRequestSize(DataSize.of(15,DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

}
