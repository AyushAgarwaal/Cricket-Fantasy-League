package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication

//@ComponentScan({"com.example.demo.Controller","com.example.demo.repository"})
@EnableJpaRepositories
@SpringBootApplication
public class FantasyLeagueCricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(FantasyLeagueCricketApplication.class, args);
	}

}
