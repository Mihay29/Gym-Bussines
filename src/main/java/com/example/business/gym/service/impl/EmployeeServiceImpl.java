package com.example.business.gym.service.impl;


import com.example.business.gym.entity.Employee;
import com.example.business.gym.repository.EmployeeRepository;
import com.example.business.gym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
    @Transactional
    @Override
    public Employee updateEmployeeById(Integer id, Employee employee){
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setAddress(employee.getAddress());
                    existingEmployee.setEmail(employee.getEmail());
                    existingEmployee.setFirstName(employee.getFirstName());
                    existingEmployee.setLastName(employee.getLastName());
                    existingEmployee.setPhone(employee.getPhone());
                    return employeeRepository.save(existingEmployee);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }
    @Override
    public boolean deleteEmployeeById(int id){
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    employeeRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
