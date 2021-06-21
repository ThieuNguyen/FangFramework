package com.fang.springmongodb.employee.service;

import com.fang.springmongodb.employee.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(String id);

    Employee findEmployeeByName(String name);

    List<Employee> findAllEmployee();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String id);
}
