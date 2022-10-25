package com.hyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * House模块启动类.
 *
 * @author hyx
 **/

@EnableFeignClients
@SpringBootApplication
public class HouseApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }
}
