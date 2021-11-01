package com.example.employee.crud.crudoperations.service;

import com.example.employee.crud.crudoperations.model.Employee;
import com.example.employee.crud.crudoperations.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl {
    @Autowired
    private EmployeeRepository empRepository;

    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    public void saveEmployee(Employee empModel) {
        this.empRepository.save(empModel);
    }

    public Employee getEmployeeById(long id) {
        Optional<Employee> optionalEmpModel = empRepository.findById(id);
        Employee empModel = null;
        if (optionalEmpModel.isPresent()){
            empModel = optionalEmpModel.get();
        }else {
            throw new RuntimeException("Employee is not exist: " + id);
        }
        return empModel;
    }


    public void deleteEmployeeById(long id) {
        empRepository.deleteById(id);
    }
}
