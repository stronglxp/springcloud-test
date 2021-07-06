package com.codeliu.consumer.payment.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  // 让RestTemplate有负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
