package com.example.mongoDbwebFlux.service;

import com.example.mongoDbwebFlux.dto.EmployeDto;


import org.springframework.web.bind.annotation.RequestParam;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeDto> findById (String id);
    Flux<EmployeDto> getAll();
    Mono<EmployeDto> saveEmployee(Mono<EmployeDto> employeDtoMono);
    Mono<EmployeDto> updateEmployee(Mono<EmployeDto> employeDtoMono,String id);
    Flux<EmployeDto> getEmployeeInRange(@RequestParam("firstId") String firstId, @RequestParam("lastId")String lastId);


}
