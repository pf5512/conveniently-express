package com.neng;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class NengApplication {

	public static void main(String[] args) {
		SpringApplication.run(NengApplication.class, args);
	}
}
