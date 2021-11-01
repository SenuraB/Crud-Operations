package com.example.employee.crud.crudoperations.controller;

import com.example.employee.crud.crudoperations.exception.ResourceNotFoundException;
import com.example.employee.crud.crudoperations.model.Employee;
import com.example.employee.crud.crudoperations.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @Controller
    @CrossOrigin(origins = "http://localhost:8080")
    @RestController
    @RequestMapping("/api/v1/")

public class EmployeeController {

        @Autowired
        private EmployeeRepository empRepository;

        // get all employees
        @GetMapping("/employees")
        public List<Employee> getAllEmployees(){
            return empRepository.findAll();
        }

        // create an employee
        @PostMapping("/employees")
        public Employee createEmployee(@RequestBody Employee empModel){
            //null
            System.out.println(empModel.getEmail());
            System.out.println(empModel.getFirstName());

            return empRepository.save(empModel);
        }


        // get employee by id
        @GetMapping("/employees/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
            Employee empModel = empRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Employee is not exist : " + id));
            return ResponseEntity.ok(empModel);
        }

        // update an employee
        @PutMapping("/employees/{id}")
        public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee empDetails){
            Employee empModel = empRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Employee is not exist : " + id));

            empModel.setFirstName(empDetails.getFirstName());
            empModel.setLastName(empDetails.getLastName());
            empModel.setEmail(empDetails.getEmail());

            Employee updatedEmp = empRepository.save(empModel);
            return ResponseEntity.ok(updatedEmp);
        }

        // delete an employee by id
        @DeleteMapping("/employees/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id){
            Employee empModel = empRepository.findById(id).
                    orElseThrow(()-> new ResourceNotFoundException("Employee is not exist : " + id));

            empRepository.delete(empModel);
            Map<String, Boolean> response = new HashMap<>();
            response.put(("Employee is deleted : " + id), Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    }