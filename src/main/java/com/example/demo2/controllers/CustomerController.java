package com.example.demo2.controllers;
import com.example.demo2.models.Customer;
import com.example.demo2.repostiories.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/customers")
public class CustomerController
{
    @Autowired
    CustomerRepository customerRepository;

    @GET
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer getCustomer(@PathParam("id") ObjectId id) {
        return customerRepository.findById(id).get();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createCustomer(@RequestBody Customer customer)
    {
        customer.setObjectId(ObjectId.get());
        customerRepository.save(customer);
        return Response.status(Response.Status.CREATED.getStatusCode()).build();
    }
}
