package com.example.mongoDbwebFlux.repo;

import com.example.mongoDbwebFlux.entity.Employee;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String>  {
    Flux<Employee> findByIdBetween(String firstId, String lastId);
}
