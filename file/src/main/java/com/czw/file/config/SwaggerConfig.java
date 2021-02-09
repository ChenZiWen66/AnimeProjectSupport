package com.czw.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docker() {
        // 构造函数传入初始化规范，这是swagger2规范
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo： 添加api详情信息，参数为ApiInfo类型的参数，这个参数包含了第二部分的所有信息比如标题、描述、版本之类的，开发中一般都会自定义这些信息
                .apiInfo(apiInfo())
                .groupName("网站服务文档")
                //配置是否启用Swagger，如果是false，在浏览器将无法访问，默认是true
                .enable(true)
                .select()
                //apis： 添加过滤条件,
                .apis(RequestHandlerSelectors.basePackage(""))
                //paths： 这里是控制哪些路径的api会被显示出来
                .paths(PathSelectors.ant("/**/*"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("陈子文：", "无", "401030526@qq.com");
        return new ApiInfo(
                "一个仿樱花动漫网的网站", // 标题
                "仅供个人学习的网站", // 描述
                "1.0.0", // 版本
                "无组织", // 组织链接
                contact, // 联系人信息
                "无许可", // 许可
                "无许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
