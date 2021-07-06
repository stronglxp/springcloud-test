package com.codeliu.consumer.feign.payment.controller;

import com.codeliu.consumer.feign.payment.service.PaymentFeignService;
import com.codeliu.entity.Payment;
import com.codeliu.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/consumer/order/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/consumer/feign/timeout")
    public CommonResult<Integer> testFeignTimeout() {
        // OpenFeign客户端默认等待1秒钟，我们在provider设置睡眠3s。可以在配置文件中配置openFeign超时时间
        // Read timed out executing GET http://PROVIDER-PAYMENT/payment/feign/timeout
        return paymentFeignService.testFeignTimeout();
    }
}
