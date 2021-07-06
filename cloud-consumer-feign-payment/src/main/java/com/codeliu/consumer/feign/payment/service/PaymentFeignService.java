package com.codeliu.consumer.feign.payment.service;

import com.codeliu.entity.Payment;
import com.codeliu.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient配置调用provider服务
 */
@Component
// value指定provider的名字
@FeignClient(value = "PROVIDER-PAYMENT")
public interface PaymentFeignService {

    /**
     * 这里的 url需要和 provider的 url一样，否则找不到接口
     * @param id
     * @return
     */
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public CommonResult<Integer> testFeignTimeout();
}
