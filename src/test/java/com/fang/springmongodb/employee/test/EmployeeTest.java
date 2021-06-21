package com.fang.springmongodb.employee.test;

import com.fang.springmongodb.employee.domain.Address;
import com.fang.springmongodb.employee.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;


public class EmployeeTest {
    @Test
    public void testEmployee() throws JsonProcessingException {
        Employee employee = new Employee();
        employee.setAge(30);
        employee.setName("Jack");
        employee.setSalary(5000);
        Address address = new Address();
        address.setCity("NY");
        address.setCountry("USA");
        address.setStreet("MHKC");
        address.setZipCode(38371);
        employee.setAddress(address);

        ObjectMapper mapper = new ObjectMapper();
        String employeeJson = mapper.writeValueAsString(employee);
        System.out.println(employeeJson);
    }
}
