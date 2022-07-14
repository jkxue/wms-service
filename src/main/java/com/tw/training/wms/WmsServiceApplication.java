package com.tw.training.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 仓储服务
@SpringBootApplication
@EnableEurekaClient
public class WmsServiceApplication {
	final static Logger logger = LoggerFactory.getLogger(WmsServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WmsServiceApplication.class, args);
		logger.info("WMS Service已经启动");
	}
}
