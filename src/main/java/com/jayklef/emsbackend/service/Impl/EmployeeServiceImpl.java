package com.jayklef.emsbackend.service.Impl;

import com.jayklef.emsbackend.dto.EmployeeDto;
import com.jayklef.emsbackend.entity.Employee;
import com.jayklef.emsbackend.mapper.EmployeeMapper;
import com.jayklef.emsbackend.repository.EmployeeRepository;
import com.jayklef.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
