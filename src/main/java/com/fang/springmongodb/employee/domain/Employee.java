package com.fang.springmongodb.employee.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Employee")
public class Employee {
    @Id
    String id;
    int age;
    String name;
    Address address;
    double salary;

}
