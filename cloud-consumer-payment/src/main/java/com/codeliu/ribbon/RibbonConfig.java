package com.codeliu.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon相关的配置
 * 该类不能放在不能放在@ComponentScan所扫描的当前包下以及子包下，即启动类所在包及其子包
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的
 */
@Configuration
public class RibbonConfig {

    /**
     * 配置负载均衡策略
     * @return
     */
    @Bean
    public IRule MyRule() {
        return new RoundRobinRule();
    }
}
