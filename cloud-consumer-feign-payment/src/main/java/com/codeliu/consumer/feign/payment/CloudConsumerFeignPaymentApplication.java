package com.codeliu.consumer.feign.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeignPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignPaymentApplication.class, args);
    }

}
