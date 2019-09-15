package com.victory.ddd.china.sample.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.victory.ddd.china.sample")
@MapperScan("com.victory.ddd.china.sample.infrastructure.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
