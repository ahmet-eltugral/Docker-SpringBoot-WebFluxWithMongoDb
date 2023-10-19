package com.example.mongoDbwebFlux.utils;

import com.example.mongoDbwebFlux.dto.EmployeDto;
import com.example.mongoDbwebFlux.entity.Employee;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {


    public static EmployeDto entityToDto(Employee employee) {
        EmployeDto employeDto = new EmployeDto();
        BeanUtils.copyProperties(employee, employeDto);
        return employeDto;
    }

    public static Employee dtoToEntity(EmployeDto productDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(productDto, employee);
        return employee;
    }
}
