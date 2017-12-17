package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.project.Entity.Data;
import com.project.Repositories.DataRepository;


@SpringBootApplication
public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainController.class, args);
	}

}
