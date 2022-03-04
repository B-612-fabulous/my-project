package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@MapperScan(basePackages = "com.zj.**.dao.**", annotationClass = Repository.class)
public class ZjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjApplication.class, args);
    }
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }

}
