package com.fang.springmongodb.employee.service;

import com.fang.springmongodb.employee.domain.Employee;
import com.fang.springmongodb.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee findEmployeeById(String id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAllEmployee();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
    }

}
