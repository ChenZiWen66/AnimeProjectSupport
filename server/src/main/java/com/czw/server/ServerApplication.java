package com.czw.server;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.czw.server.module.mapper")
@SpringBootApplication
public class ServerApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ServerApplication.class);
    public static void main(String[] args) {
        LOG.info("服务模块开始启动");
        SpringApplication.run(ServerApplication.class, args);
        LOG.info("服务模块启动成功: http://localhost:9001");
    }
}
