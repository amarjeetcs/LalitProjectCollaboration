package com.amarjeet.singh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.entity")
public class CrudApplicationMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplicationMasterApplication.class, args);
	}

}
