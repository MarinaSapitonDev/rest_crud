package com.example.d1.controller;

import com.example.d1.entity.Customer;
import com.example.d1.exception.MyResourceNotFoundException;
import com.example.d1.helper.JSONMapperHelper;
import com.example.d1.preconditions.RestPreconditions;
import com.example.d1.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final CustomerServiceImpl customerService;

    @Autowired
    CustomerRestController(CustomerServiceImpl customerService){
        this.customerService = customerService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/returnJSON")
    public Customer returnCustomerJSON(){
        JSONMapperHelper helper = new JSONMapperHelper();
        return helper.returnCustomerJSON();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
       return customerService.getCustomers();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        try {
            RestPreconditions.checkFound(customer);
        } catch (MyResourceNotFoundException e) {
            e.printStackTrace();
        }

        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody Customer customer) {
        try {
            RestPreconditions.checkFound(customer);
        } catch (MyResourceNotFoundException e) {
            e.printStackTrace();
        }
        customerService.updateCustomer(customer);
        return customer;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id")int id){
        customerService.deleteCustomer(id);
    }

}
