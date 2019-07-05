package com.fdh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @description:  Boss-Admin启动类
 * @date: 2019/6/3 15:24
 * @author: fdh
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.fdh.business.modules.**.dao")
public class BossApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BossApplication.class, args);
	}

	/**
	 * @description: 配置外置tomcat部署
	 * @date: 2019/7/4 11:04
	 * @author: fdh
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BossApplication.class);
	}

}
