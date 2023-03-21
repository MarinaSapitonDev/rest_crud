package com.example.d1.dao;

import com.example.d1.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Poornima","Pit","mylo"));
        customers.add(new Customer(2,"Mario","Rozari","mylo"));
        customers.add(new Customer(3,"Selena","Gomez","email"));

        return customers;
    }

    public Optional<Customer> getCustomer(int id){
        return Optional.empty();
    }

    public void saveCustomer(Customer customer){
        System.out.println("customer "+customer.firstName()+ "saved to db");

    }

    public void updateCustomer(int id, Customer customer){
        System.out.println("customer "+customer.firstName()+ " with id "+ id +" updated");

    }

    public void deleteCustomer(int id){
        System.out.println("customer whit id "+ id + " deleted");
    }
}
