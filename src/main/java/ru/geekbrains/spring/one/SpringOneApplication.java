package ru.geekbrains.spring.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOneApplication {
	// Домашнее задание
	// Разобраться с примером проекта на Spring MVC;
	// Создать класс Товар (Product), с полями id, title, cost;
	// Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары). Репозиторий должен уметь выдавать список всех товаров и товар по id;
	// * Сделать форму для добавления товара в репозиторий и логику работы этой формы;
	// Сделать страницу, на которой отображаются все товары из репозитория.
	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
	}
}
