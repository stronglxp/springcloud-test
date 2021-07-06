package com.codeliu.provider.payment.controller;

import com.codeliu.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * eureka服务发现: 简单来讲就是通过服务名找到提供服务的实例地址和端口，主要用于解决如何获取服务实例地址问题。
 * 正常情况下我们访问服务时需要知道服务的地址和端口号，如果服务实例地址和端口号都是固定的，我们可以在直接写在配置文件中，
 * 但大多数线上生产环境尤其是容器部署情况下服务实例地址都是动态分配的，只有服务实例部署之后才能获得实际地址。
 * 服务调用者根本无法提前获取服务实例地址和端口，只能在运行时通过服务发现组件解析服务名来获取服务实例地址和端口。
 */
@RestController
@Slf4j
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery/payment")
    public CommonResult<Object> discovery() {
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(service -> log.info("service => {}", service));

        // 通过实例名获取服务实例
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER-PAYMENT");
        instanceList.stream().forEach(instance -> log.info(instance.getServiceId() + "\t" +
                instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri()));

        return new CommonResult<>(200, "", this.discoveryClient);
    }
}
