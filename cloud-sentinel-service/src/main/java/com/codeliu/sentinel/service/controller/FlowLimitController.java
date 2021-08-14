package com.codeliu.sentinel.service.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.codeliu.sentinel.service.handler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return p1 + " " + p2;
    }

    /**
     * 处理sentinel的异常，注意方法必须是public类型，不然报错
     * java.lang.IllegalAccessException: Class com.alibaba.csp.sentinel.annotation.aspectj.AbstractSentinelAspectSupport can not access a member
     * @return
     */
    public String dealTestHotKey(String p1, String p2, BlockException e) {
        return "处理sentinel异常";
    }

    @GetMapping("/hanlder")
    @SentinelResource(value = "handler",
            blockHandlerClass = CustomerHandler.class,  // 指定哪个类
            blockHandler = "handler1")   // 指定哪个方法
    public String testHandler() {
        return "testHandler";
    }
}
