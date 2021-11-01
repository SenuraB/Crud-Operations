package com.example.employee.crud.crudoperations.repository;

import com.example.employee.crud.crudoperations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// use JPA repo for crud operations (findById(), getById(), findAll())

}