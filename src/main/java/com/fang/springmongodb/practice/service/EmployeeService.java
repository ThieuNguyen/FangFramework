package com.fang.springmongodb.practice.service;

import com.fang.springmongodb.practice.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(String id);

    Employee findEmployeeByName(String name);

    List<Employee> findAllEmployee();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String id);
}
