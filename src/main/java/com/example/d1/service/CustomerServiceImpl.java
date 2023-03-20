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

    public Customer getCustomer(int id){                 //add message () -> new IllegalArgEx("msg)
        //return customerDAO.getCustomer(id).orElseThrow(IllegalArgumentException::new );//can be exception
        return customerDAO.getCustomer(id).orElseThrow(()-> new IllegalArgumentException("msg"));//can be exception
    }
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }


    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }
}
