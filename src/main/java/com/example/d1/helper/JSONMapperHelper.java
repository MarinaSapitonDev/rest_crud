package com.example.d1.helper;

import com.example.d1.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONMapperHelper {

    public Customer returnCustomerJSON() {
        Customer customer = new Customer();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            customer = objectMapper.readValue(new File("data/customer.json"), Customer.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

}
