package com.example.business.gym.service;

import com.example.business.gym.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> getEmployeeById(int id);
    Employee createEmployee(Employee employee);
    Employee updateEmployeeById(Integer id, Employee employee);
    boolean deleteEmployeeById(int id);
}
