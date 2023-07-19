package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.service.BeleggingsService;
import com.befrank.casedeveloperjava.service.DefaultPensioenServiceImpl;
import com.befrank.casedeveloperjava.service.MockBeleggingsServiceImpl;
import com.befrank.casedeveloperjava.service.PensioenService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CaseDeveloperJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseDeveloperJavaApplication.class, args);
	}

	@Bean
	public BeleggingsService getBeleggingsService() {
		return new MockBeleggingsServiceImpl();
	}

	@Bean
	public PensioenService getPensioenService() {
		return new DefaultPensioenServiceImpl();
	}
}
