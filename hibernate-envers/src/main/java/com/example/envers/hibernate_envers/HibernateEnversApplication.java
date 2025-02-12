package com.example.envers.hibernate_envers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateEnversApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateEnversApplication.class, args);
	}

}
