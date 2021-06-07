package com.fang.springmongodb.practice.controller;

import com.fang.springmongodb.practice.domain.Employee;
import com.fang.springmongodb.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable("id") String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/")

    public Employee createNewEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        if(employee.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Employee Id is null"
            );
        }
        if (ObjectUtils.isEmpty(employeeService.findEmployeeById(employee.getId()))) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee not found"
            );
        }
        return employeeService.updateEmployee(employee);
    }
}
