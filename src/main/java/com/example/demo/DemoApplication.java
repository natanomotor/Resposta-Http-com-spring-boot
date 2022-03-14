package com.example.demo;

import com.example.demo.Service.InitService;
import com.example.demo.Service.SiteService;
import com.example.demo.entities.Site;
import com.example.demo.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)throws Exception {
		InitService initService = new InitService();
		SpringApplication.run(DemoApplication.class, args);

	}
	}

