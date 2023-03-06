package com.example.d1.dao;

import com.example.d1.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
