package com.example.demo2.repostiories;

import com.example.demo2.models.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, ObjectId>
{

}

