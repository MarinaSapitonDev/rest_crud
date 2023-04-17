package com.example.d1.dao;

import com.example.d1.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> findAll();

    Customer findByID(int id);

    void save (Customer customer);

    Customer update(Customer customer);

    void deleteByID(int id);

    List<Customer> getCustomers();

    Optional<Customer> getCustomer(int id);

    void saveCustomer(Customer customer);

    void updateCustomer(int id,Customer customer);

    void deleteCustomer(int id);
}
