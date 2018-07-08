package com.manojbehera.emsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmSpringMvcApplication.class, args);

		// if the spring configuration files are in different packages.
		// SpringApplication.run(new Class [] {EmSpringMvcApplication.class,
		// SpringSecurityConfig.class,
		// SpringWebMvcConfiguration.class});
	}
}
