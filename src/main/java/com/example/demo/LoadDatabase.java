package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRespository;

@Configuration
public class LoadDatabase {
	
	
	  @Bean
	  CommandLineRunner initDatabase(EmployeeRespository repository) {

	    return args -> {
	       repository.save(new Employee(1, "Lokesh", "Gupta", "lokesh@gmail.com"));
	       repository.save(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
	       repository.save(new  Employee(3, "David", "Kameron", "titanic@gmail.com"));
	    };
	  }
	}
	
	


