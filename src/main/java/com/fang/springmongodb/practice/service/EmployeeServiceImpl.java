package com.fang.springmongodb.practice.service;

import com.fang.springmongodb.practice.domain.Employee;
import com.fang.springmongodb.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
