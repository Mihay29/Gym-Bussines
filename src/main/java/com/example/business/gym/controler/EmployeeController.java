package com.example.business.gym.controler;

import com.example.business.gym.entity.Employee;
import com.example.business.gym.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

   private final EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl){
        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable Integer id) {
        return employeeServiceImpl.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.createEmployee(employee));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.updateEmployeeById(id,employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer id) {
        if (employeeServiceImpl.deleteEmployeeById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
