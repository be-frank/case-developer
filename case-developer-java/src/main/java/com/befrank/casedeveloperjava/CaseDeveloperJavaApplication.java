package com.befrank.casedeveloperjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CaseDeveloperJavaApplication {

  public static void main(String[] args) {
    SpringApplication.run(CaseDeveloperJavaApplication.class, args);
  }
}
