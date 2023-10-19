package com.example.mongoDbwebFlux.bean;

import com.example.mongoDbwebFlux.dto.EmployeDto;
import com.example.mongoDbwebFlux.repo.EmployeeRepository;
import com.example.mongoDbwebFlux.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeSaveBean {
    private final EmployeeRepository employeeRepository;

    public Mono<EmployeDto> saveEmploye(Mono<EmployeDto> employeDtoMono) {
        return  employeDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(employeeRepository::insert)
                .map(AppUtils::entityToDto);
    }
}
