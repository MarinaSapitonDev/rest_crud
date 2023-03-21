package com.example.d1.preconditions;

import com.example.d1.entity.Customer;
import com.example.d1.exception.MyResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link RestPreconditions}
 */
class RestPreconditionsTest {
    @Test
    void testExpectedException() {

        MyResourceNotFoundException exception = Assertions.assertThrows(MyResourceNotFoundException.class, () -> {
            RestPreconditions.checkFound(null);
        });

        Assertions.assertEquals("data was not entered correctly", exception.getMessage());
    }

    @Test
    void testNoException() {
        Customer customer = new Customer(1,"Maryna", "Sapiton","mail");

        Assertions.assertDoesNotThrow(() -> {
            RestPreconditions.checkFound(customer);
        });
    }

}