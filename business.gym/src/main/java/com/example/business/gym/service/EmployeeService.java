package com.example.business.gym.service;

import com.example.business.gym.entity.Employee;
import com.example.business.gym.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

@Service
public class EmployeeService {


    private EmployeeRepository employeeSRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeSRepository) {
        this.employeeSRepository = employeeSRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeSRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(int id) {
        Optional<Employee> employee = employeeSRepository.findById(id);
        if (employee.isPresent()) {
            return Optional.of(employee.get());
        }else {
            return Optional.empty();
        }
    }
    public Optional<Employee> updateEmployeeById(Integer id, Employee employee) {
        Optional<Employee> employeeOptional = findEmployeeById(id);
        if (employeeOptional.isPresent()) {
            Employee employeeToUpdate = employeeOptional.get();

            employeeToUpdate.setAddress(employee.getAddress());
            employeeToUpdate.setEmail(employee.getEmail());
            employeeToUpdate.setFirstName(employee.getFirstName());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setPhone(employee.getPhone());
            return Optional.of(employeeSRepository.save(employeeToUpdate));
        }
        else{
            return Optional.empty();
        }
    }

    public void deleteEmployeeById(int id) {
        employeeSRepository.deleteById(id);
    }
}
