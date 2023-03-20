package com.example.d1.dao;

import com.example.d1.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Optional<Customer> getCustomer(int id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
