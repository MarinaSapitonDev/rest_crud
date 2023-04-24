package com.example.d1.dao;

import com.example.d1.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer ", Customer.class).getResultList();
    }

    @Override
    public Customer findByID(int id){
      return entityManager.find(Customer.class,id);
    }

    public Customer update(Customer customer) {
        return entityManager.merge(customer);
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void deleteByID(int id) {
        entityManager.remove(entityManager.find(Customer.class, id));
    }

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
        System.out.println("customer "+customer.getFirstName()+ "saved to db");

    }

    public void updateCustomer(int id, Customer customer){
        System.out.println("customer "+customer.getFirstName()+ " with id "+ id +" updated");

    }

    public void deleteCustomer(int id){
        System.out.println("customer whit id "+ id + " deleted");
    }
}
