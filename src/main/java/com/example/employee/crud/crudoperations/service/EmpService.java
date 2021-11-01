package com.example.employee.crud.crudoperations.service;

import com.example.employee.crud.crudoperations.model.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee empModel);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

}
