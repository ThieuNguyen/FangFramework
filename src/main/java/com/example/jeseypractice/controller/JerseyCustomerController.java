package com.example.jeseypractice.controller;

import com.example.jeseypractice.model.Customer;
import com.example.jeseypractice.repository.CustomerRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api/customers")
public class JerseyCustomerController
{
    @Autowired
    CustomerRepository customerRepository;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
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
