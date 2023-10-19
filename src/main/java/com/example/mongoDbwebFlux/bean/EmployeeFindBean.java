package com.example.mongoDbwebFlux.bean;

import com.example.mongoDbwebFlux.dto.EmployeDto;
import com.example.mongoDbwebFlux.utils.AppUtils;
import com.example.mongoDbwebFlux.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeFindBean {
    private final EmployeeRepository employeeRepository;

    public Mono<EmployeDto> getEmployee(String id) {


        return employeeRepository.findById(id).map(AppUtils::entityToDto);
    }
    public Flux<EmployeDto> getAll() {


        return employeeRepository.findAll().map(AppUtils::entityToDto);
    }
}
