package com.example.mongoDbwebFlux.service;

import com.example.mongoDbwebFlux.dto.EmployeDto;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeDto> findById (String id);
    Flux<EmployeDto> getAll();
    Mono<EmployeDto> saveProduct(Mono<EmployeDto> productDtoMono);

}
