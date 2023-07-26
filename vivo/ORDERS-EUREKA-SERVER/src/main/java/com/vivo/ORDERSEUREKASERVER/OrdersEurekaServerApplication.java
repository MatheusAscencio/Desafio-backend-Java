package com.vivo.ORDERSEUREKASERVER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OrdersEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersEurekaServerApplication.class, args);
	}

}
