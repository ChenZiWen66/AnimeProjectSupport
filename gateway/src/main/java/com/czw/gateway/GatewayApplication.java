package com.czw.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GatewayApplication {
    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);
    public static void main(String[] args) {
        LOG.info("服务模块开始启动");
        SpringApplication.run(GatewayApplication.class, args);
        LOG.info("服务模块启动成功: http://localhost:9001");
    }
}
