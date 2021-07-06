package com.codeliu.provider.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// 服务发现
@EnableDiscoveryClient
public class CloudProviderPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentApplication.class, args);
    }

}
