package com.codeliu.gateway;

import java.time.ZonedDateTime;

public class Test {
    public static void main(String[] args) {
        // 生成gateway内置路由断言工厂需要的时间戳格式 2021-07-05T10:25:20.760+08:00[Asia/Shanghai]
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }
}
