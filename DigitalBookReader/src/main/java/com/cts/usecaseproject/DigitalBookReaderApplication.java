package com.cts.usecaseproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DigitalBookReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookReaderApplication.class, args);
	}

}
