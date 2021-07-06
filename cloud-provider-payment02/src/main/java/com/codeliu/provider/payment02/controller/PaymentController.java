package com.codeliu.provider.payment02.controller;

import com.codeliu.entity.Payment;
import com.codeliu.provider.payment02.service.PaymentService;
import com.codeliu.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    // 端口号，区分是哪个生产者提供的服务
    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping("/payment")
    public CommonResult<Object> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("result = {}", result);
        if (result == 1) {
            return new CommonResult<>(200, "插入成功", result);
        } else {
            return new CommonResult(-1,"插入失败",null);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功-" + serverPort, payment);
        } else {
            return new CommonResult<>(-1, "查询失败-" + serverPort, null);
        }
    }
}
