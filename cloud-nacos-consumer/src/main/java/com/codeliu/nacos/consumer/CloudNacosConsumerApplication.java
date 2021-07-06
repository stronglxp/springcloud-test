package com.codeliu.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumerApplication.class, args);
    }

}
