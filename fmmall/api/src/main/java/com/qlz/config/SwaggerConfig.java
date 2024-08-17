package com.qlz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-17 12:43
 * @description: swagger配置类
 **/
@Configuration
public class SwaggerConfig {
	/*
		swagger会帮助生成接口文档
		1.配置生成的文档信息
		2.配置生成规则
	 */
	@Bean
	public Docket getDocket() {
		//指定文档风格
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)//是否开启
				.apiInfo(getApiInfo())//设置文档封面信息
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.qlz.controller"))//设置扫描的包
				//.paths(PathSelectors.regex("/user/"))//为部分接口生成文档
				.paths(PathSelectors.any())//为所有接口生成文档
				.build();
	}
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("标题：锋迷商城_接口文档")
				.description("描述：商城项目")
				.contact(new Contact("作者：qlz", null, null))
				.version("版本号：2.0.1")
				.build();
	}
}
