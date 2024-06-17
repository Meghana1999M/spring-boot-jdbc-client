package com.example.spring_boot_jdbc_client;

import org.springframework.boot.SpringApplication;

public class TestSpringBootJdbcClientApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootJdbcClientApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
