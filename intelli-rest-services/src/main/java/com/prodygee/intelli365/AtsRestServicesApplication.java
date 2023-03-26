package com.prodygee.intelli365;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages={"com.prodygee.intelli365"})
@EnableJpaRepositories(basePackages = "com.prodygee.intelli365.ats.repository")
public class AtsRestServicesApplication {

	
 
	public static void main(String[] args) {
		SpringApplication.run(AtsRestServicesApplication.class, args);
	}
	
	
}

