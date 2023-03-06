package com.example.d1.preconditions;

import com.example.d1.exception.MyResourceNotFoundException;

public class RestPreconditions {
    public static <T> T checkFound(T resource) throws MyResourceNotFoundException {
        if (resource == null) {
            throw new MyResourceNotFoundException("data was not entered correctly");
        }
        return resource;
    }
}