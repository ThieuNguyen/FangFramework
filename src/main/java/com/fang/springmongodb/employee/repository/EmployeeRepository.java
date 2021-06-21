package com.fang.springmongodb.employee.repository;

import com.fang.springmongodb.employee.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findEmployeeById(String id);

    Employee findByName(String name);

    List<Employee> findAllEmployee();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String id);
}
