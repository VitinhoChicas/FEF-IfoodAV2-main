package com.trabalho.ifood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.trabalho.ifood")
@EntityScan(basePackages ={ "com.trabalho.ifood.domains", "com.trabalho.ifood.domains.enums"})
@EnableJpaRepositories(basePackages = "com.trabalho.ifood.repositories")
@SpringBootApplication
public class IfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IfoodApplication.class, args);
	}

}
