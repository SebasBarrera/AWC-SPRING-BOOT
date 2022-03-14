package com.sebas.taller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sebas.taller")
public class TallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerApplication.class, args);
	}

}
