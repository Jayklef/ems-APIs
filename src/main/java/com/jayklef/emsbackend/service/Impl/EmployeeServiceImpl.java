package com.jayklef.emsbackend.service.Impl;

import com.jayklef.emsbackend.dto.EmployeeDto;
import com.jayklef.emsbackend.entity.Employee;
import com.jayklef.emsbackend.mapper.EmployeeMapper;
import com.jayklef.emsbackend.repository.EmployeeRepository;
import com.jayklef.emsbackend.service.EmployeeService;
import com.jayklef.emsbackend.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Resource with id of " + employeeId + " not found")
        );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> allEmployees(){
        List<Employee> employees = employeeRepository.findAll();
       return employees.stream()
               .map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
               .collect(Collectors.toList());
    }
}
