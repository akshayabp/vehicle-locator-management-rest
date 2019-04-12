package org.apawaskar.vehiclelocator.config;


import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="org.apawaskar.vehiclelocator")
public class ManagementApplication {

	public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }
}
