package com.example.mongoDbwebFlux.controller;

import com.example.mongoDbwebFlux.dto.EmployeDto;
import com.example.mongoDbwebFlux.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Mono<EmployeDto> getById(@RequestParam String id){
        return employeeService.findById(id);
    }
    @GetMapping("/getAll")
    public Flux<EmployeDto> getAll(){
        return employeeService.getAll();
    }
    @GetMapping("/employee-range")
    public Flux<EmployeDto> getEmployeeBetweenRange(@RequestParam("firstId") String firstId, @RequestParam("lastId")String lastId){
        return employeeService.getEmployeeInRange(firstId,lastId);
    }
    @PostMapping("/saveEmployee")
    public Mono<EmployeDto> save(@RequestBody EmployeDto employeDtoMonoDtoMono){
        return employeeService.saveEmployee(Mono.just(employeDtoMonoDtoMono));
    }
    @PutMapping("/updateEmployee/{id}")
    public Mono<EmployeDto> update(@RequestBody EmployeDto employeDto,@PathVariable String id){
        return employeeService.updateEmployee(Mono.just(employeDto),id);
    }
}
