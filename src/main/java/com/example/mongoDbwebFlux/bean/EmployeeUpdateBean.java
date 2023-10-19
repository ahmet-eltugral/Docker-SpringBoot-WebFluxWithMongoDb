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
public class EmployeeUpdateBean {
    private final EmployeeRepository employeeRepository;

    public Mono<EmployeDto> updateEmployee(Mono<EmployeDto> employeDtoMono, String id){
        return employeeRepository.findById(id)
                .flatMap(e->employeDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(p->p.setId(id)))
                .flatMap(employeeRepository::save)
                .map(AppUtils::entityToDto);
    }
}
