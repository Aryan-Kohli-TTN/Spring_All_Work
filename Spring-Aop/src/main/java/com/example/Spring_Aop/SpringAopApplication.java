package com.example.Spring_Aop;

import com.example.Spring_Aop.Business.Business1;
import com.example.Spring_Aop.Business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(SpringAopApplication.class);

	@Autowired
	Business1 business1;
	@Autowired
	Business2 business2;


	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		logger.info(business1.getSomething());
		logger.info(business2.getSomething());
	}

}
