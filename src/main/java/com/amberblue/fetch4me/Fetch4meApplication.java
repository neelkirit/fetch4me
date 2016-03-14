package com.amberblue.fetch4me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.amberblue.fetch4me")
@ComponentScan(basePackages = "com.amberblue.fetch4me")
public class Fetch4meApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fetch4meApplication.class, args);
	}
}
