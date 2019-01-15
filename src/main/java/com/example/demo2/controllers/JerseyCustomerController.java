/**
 * Copyright (c) 2019 Absolute Software Corporation. All rights reserved. Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic, mechanical or
 * otherwise, is prohibited without the prior written consent of the copyright owner.
 */
package com.example.demo2.controllers;

import com.example.demo2.models.Customer;
import com.example.demo2.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Controller
@Path("/api/customer")
public class JerseyCustomerController {
    @Autowired
    private CustomerService customerService;

    @GET
    @Produces("application/json")
    public List<Customer> getAllCustomer(){
        return customerService.findAll();
    }
}
