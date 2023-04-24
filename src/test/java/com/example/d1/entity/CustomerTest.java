package com.example.d1.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void whenGetNameAndEmail_thenExpectedValuesReturned() {
        String name = "John Doe";
        String lastName = "Linda";
        int id = 1;
        String email = "@mail";

        Customer customer = new Customer(id,name, lastName,email);

        assertEquals(id, customer.id());
        assertEquals(name, customer.firstName());
        assertEquals(lastName, customer.lastName());
        assertEquals(email, customer.email());
    }

}