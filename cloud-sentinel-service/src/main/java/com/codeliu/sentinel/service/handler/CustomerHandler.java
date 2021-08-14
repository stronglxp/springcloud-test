package com.codeliu.sentinel.service.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerHandler {
    public static String handler1(BlockException exception) {
        return "handler1: " + exception.getMessage();
    }

    public static String handler2(BlockException exception) {
        return "handler2: " + exception.getMessage();
    }
}
