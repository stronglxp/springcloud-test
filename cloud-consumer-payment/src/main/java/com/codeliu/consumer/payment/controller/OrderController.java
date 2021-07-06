package com.codeliu.consumer.payment.controller;

import com.codeliu.entity.Payment;
import com.codeliu.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    @Value("${payment-url}")
    private String PAYMENT_URL;

    // 服务提供者向eureka注册后，服务名是服务提供者名字的全大写，只有在restTemplate有负载均衡的能力后，才能通过名字访问
    // Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号，且该服务还有负载功能。
    // 可以有多个相同的服务提供者，名字一样，端口号不同，消费者通过名字根据指定负载均衡策略访问服务提供者
    private String providerUrl = "http://PROVIDER-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment")
    public CommonResult<Object> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonResult.class);
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(providerUrl + "/payment/" + id, CommonResult.class);
    }
}
