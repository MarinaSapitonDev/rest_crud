package com.example.d1.controller;

import com.example.d1.entity.Customer;
import com.example.d1.exception.MyResourceNotFoundException;
import com.example.d1.preconditions.RestPreconditions;
import com.example.d1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/db/customers")
    public List<Customer> findAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/db/customers/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping("/db/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        try {
            RestPreconditions.checkFound(customer);
        } catch (MyResourceNotFoundException e) {
            e.printStackTrace();
        }

        customerService.save(customer);
        return customer;
    }

    @PutMapping(value = "/db/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody @NonNull Customer customer,@PathVariable int id) {
        return customerService.update(customer);
    }

    @DeleteMapping(value = "db/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id")int id) {
        customerService.deleteByID(id);
    }

    //test this method
    //tested, got the exception
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
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

       // customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

  /*  @PutMapping(value = "customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody @NonNull Customer customer,@PathVariable int id) {
        customerService.updateCustomer(id,customer);
        return customer;
    }

    @DeleteMapping(value = "customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id")int id){
        customerService.deleteCustomer(id);
    }*/
}
