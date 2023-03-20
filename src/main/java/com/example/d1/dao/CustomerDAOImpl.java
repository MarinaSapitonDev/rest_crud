package com.example.d1.dao;

import com.example.d1.entity.Customer;
import com.example.d1.helper.JSONMapperHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Poornima","Pit"));
        customers.add(new Customer("Mario","Rozari"));
        customers.add(new Customer("Selena","Gomez"));

        return customers;
    }

    public Optional<Customer> getCustomer(int id){
        return Optional.empty();
    }

    public void saveCustomer(Customer customer){
        System.out.println("customer "+customer.getFirstName()+ "saved to db");

    }

    public void updateCustomer(Customer customer){
        System.out.println("customer "+customer.getFirstName()+ "updated");

    }

    public void deleteCustomer(int id){
        System.out.println("customer whit id "+ id + " deleted");
    }
}
