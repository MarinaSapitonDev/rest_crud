package com.example.d1.service;

import com.example.d1.dao.CustomerDAO;
import com.example.d1.entity.Customer;
import jakarta.transaction.Transactional;
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
    public List<Customer> findAll(){
        return customerDAO.findAll();
    }

    public Customer findById(int id){
        return customerDAO.findByID(id);
    }

    @Transactional
    public void save(Customer customer){
         customerDAO.save(customer);
    }
    @Transactional
    public Customer update(Customer customer){
        return customerDAO.update(customer);
    }

    @Transactional
    public void deleteByID(int id) {
        customerDAO.deleteByID(id);
    }

    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    public Customer getCustomer(int id){
        return customerDAO.getCustomer(id).orElseThrow(()-> new IllegalArgumentException("incorrect format"));
    }

    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public void updateCustomer(int id,Customer customer) {
        customerDAO.updateCustomer(id, customer);
    }


    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }
}
