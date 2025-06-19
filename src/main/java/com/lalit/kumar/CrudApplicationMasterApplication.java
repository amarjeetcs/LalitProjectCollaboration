package com.lalit.kumar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class CrudApplicationMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplicationMasterApplication.class, args);
	}

}
