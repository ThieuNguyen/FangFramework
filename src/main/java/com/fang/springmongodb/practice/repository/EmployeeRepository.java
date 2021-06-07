package com.fang.springmongodb.practice.repository;

import com.fang.springmongodb.practice.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findEmployeeById(String id);

    Employee findByName(String name);

    List<Employee> findAllEmployee();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String id);
}
