package com.example.SpringBootAssigment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties(prefix = "main")
public class SpringBootAssigmentApplication implements CommandLineRunner {

	@Autowired
	Main main;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssigmentApplication.class, args);
	}
	public void run(String...args){
		System.out.println(main.getAuthorAge());
		System.out.println(main.getAuthorName());
		System.out.println(main.getAuthorCompany());

	}
}
