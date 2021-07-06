package com.codeliu.provider.payment02.controller;

import com.codeliu.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FeignController {
    // 端口号，区分是哪个生产者提供的服务
    @Value("${server.port}")
    private Integer serverPort;

    /**
     * 测试 feign超时
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public CommonResult<Integer> testFeignTimeout() {
        try {
            // 睡眠3s
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<>(0, "success", serverPort);
    }
}
