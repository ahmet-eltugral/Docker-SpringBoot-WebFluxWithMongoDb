package com.example.mongoDbwebFlux;

import com.example.mongoDbwebFlux.entity.Employee;
import com.example.mongoDbwebFlux.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class MongoDbWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbWebFluxApplication.class, args);
	}

}
