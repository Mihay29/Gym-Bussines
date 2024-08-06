package com.example.business.gym.controler;

import com.example.business.gym.entity.Employee;
import com.example.business.gym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
       return employeeService.findEmployeeById(id);
    }
    @PutMapping("/{id}")
    public Optional<Employee> updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id,employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }


}
