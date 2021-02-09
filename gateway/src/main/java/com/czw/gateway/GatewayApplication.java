package com.czw.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class GatewayApplication {
    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);
    public static void main(String[] args) {
        LOG.info("网关模块开始启动");
        SpringApplication springApplication = new SpringApplication(GatewayApplication.class);
        Environment environment = springApplication.run(args).getEnvironment();
        LOG.info("网关模块启动成功: http://localhost:{}",environment.getProperty("server.port"));
    }
}
