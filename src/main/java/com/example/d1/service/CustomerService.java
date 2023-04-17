package com.example.d1.service;

import com.example.d1.entity.Customer;

import java.util.List;

public interface CustomerService {
     List<Customer> findAll();

     Customer findById(int id);

     void save(Customer customer);

     Customer update(Customer customer);

     void deleteByID(int id);

     List<Customer> getCustomers();

     Customer getCustomer(int id);

     void saveCustomer(Customer customer);

     void updateCustomer(int id,Customer customer);

     void deleteCustomer(int id);
}
