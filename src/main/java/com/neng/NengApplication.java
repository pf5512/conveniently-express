package com.neng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class NengApplication {

	public static void main(String[] args) {
		SpringApplication.run(NengApplication.class, args);
	}
}
