package com.czw.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class FileApplication {
    private static final Logger LOG = LoggerFactory.getLogger(FileApplication.class);

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(FileApplication.class);
        ConfigurableEnvironment environment = springApplication.run(args).getEnvironment();
        LOG.info("文件传输服务启动成功,http://localhost:{}",environment.getProperty("server.port"));
    }

}
