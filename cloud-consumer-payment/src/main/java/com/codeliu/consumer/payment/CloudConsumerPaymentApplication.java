package com.codeliu.consumer.payment;

import com.codeliu.ribbon.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-PAYMENT", configuration = {RibbonConfig.class})
public class CloudConsumerPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerPaymentApplication.class, args);
    }

}
