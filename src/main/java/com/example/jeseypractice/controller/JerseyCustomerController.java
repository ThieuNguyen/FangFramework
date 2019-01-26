package com.example.jeseypractice.controller;

import com.example.jeseypractice.model.Customer;
import com.example.jeseypractice.repository.CustomerRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class JerseyCustomerController
{
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }

    @GetMapping("/count")
    public int getNumberOfCustomer()
    {
        return customerRepository.findAll().size();
    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") ObjectId id) {
        return customerRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCustomer(@RequestBody Customer customer)
    {
        customer.setObjectId(ObjectId.get());
        customerRepository.save(customer);
    }
}
