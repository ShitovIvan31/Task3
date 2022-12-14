package ru.geekbrains.spring.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.geekbrains.spring.one.repository")
public class SpringOneApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
	}
}
