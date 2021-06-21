package com.fang.springmongodb.employee.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Address")
public class Address {
    String city;
    String country;
    String street;
    int zipCode;
}
