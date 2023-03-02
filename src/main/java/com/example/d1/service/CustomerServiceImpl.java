package com.example.d1.service;

import com.example.d1.dao.CustomerDAO;
import com.example.d1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerDAO customerDAO;

    @Autowired
    CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    public Customer getCustomer(int id){
        return customerDAO.getCustomer(id);
    }
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }
}
