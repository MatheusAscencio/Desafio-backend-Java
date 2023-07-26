package com.vivo.ORDERSGATEWAY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrdersGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersGatewayApplication.class, args);
	}

}
