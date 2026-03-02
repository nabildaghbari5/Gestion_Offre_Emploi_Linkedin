package com.wingbels.belssagediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BelsSageDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelsSageDiscoveryApplication.class, args);
	}

}
