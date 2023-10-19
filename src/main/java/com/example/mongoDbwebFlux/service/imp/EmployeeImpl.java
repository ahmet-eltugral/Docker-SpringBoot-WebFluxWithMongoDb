package com.example.mongoDbwebFlux.service.imp;

import com.example.mongoDbwebFlux.bean.EmployeeFindBean;
import com.example.mongoDbwebFlux.bean.EmployeeSaveBean;
import com.example.mongoDbwebFlux.dto.EmployeDto;
import com.example.mongoDbwebFlux.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeImpl implements EmployeeService {
    private final EmployeeFindBean employeeFindBean;
    private final EmployeeSaveBean employeeSaveBean;

    @Override
    public Mono<EmployeDto> findById(String id) {
        return employeeFindBean.getEmployee(id);
    }

    @Override
    public Flux<EmployeDto> getAll() {
        return employeeFindBean.getAll();
    }

    @Override
    public Mono<EmployeDto> saveProduct(Mono<EmployeDto> employeDtoMono) {
         return  employeeSaveBean.saveEmploye(employeDtoMono);
    }
}
