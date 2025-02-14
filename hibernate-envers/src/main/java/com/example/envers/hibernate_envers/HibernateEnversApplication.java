package com.example.envers.hibernate_envers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware",dateTimeProviderRef = "auditingDateTimeProvider")
public class HibernateEnversApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Chicago"));
		SpringApplication.run(HibernateEnversApplication.class, args);
	}

	@Bean
	AuditorAware<String> auditorAware(){
		return new ApplicationAuditAware();
	}

	 @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now(ZoneId.of("America/Chicago")));
    }
}
