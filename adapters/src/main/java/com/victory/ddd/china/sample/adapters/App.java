package com.victory.ddd.china.sample.adapters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.victory.ddd.china.sample")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
