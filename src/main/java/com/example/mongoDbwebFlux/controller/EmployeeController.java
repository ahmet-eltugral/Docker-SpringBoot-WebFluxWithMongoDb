package com.example.mongoDbwebFlux.controller;

import com.example.mongoDbwebFlux.dto.EmployeDto;
import com.example.mongoDbwebFlux.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/{id}")
    public Mono<EmployeDto> getById(@PathVariable String id){
        return employeeService.findById(id);
    }
    @GetMapping("/getAll")
    public Flux<EmployeDto> getAll(){
        return employeeService.getAll();
    }
    @PostMapping("/save")
    public Mono<EmployeDto> save(@RequestBody EmployeDto employeDtoMonoDtoMono){
        return employeeService.saveProduct(Mono.just(employeDtoMonoDtoMono));
    }
}
