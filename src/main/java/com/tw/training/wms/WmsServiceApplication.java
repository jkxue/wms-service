package com.tw.training.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 仓储服务
@SpringBootApplication
@EnableEurekaClient
public class WmsServiceApplication {
	static Logger logger = LoggerFactory.getLogger(WmsServiceApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(WmsServiceApplication.class).web(true).run(args);
		logger.info("WMS Service已经启动");
	}
}
