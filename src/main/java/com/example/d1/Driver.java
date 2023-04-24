package com.example.d1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public Student returnStudentJSON() {
        Student student = new Student();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            student = objectMapper.readValue(new File("data/sample.json"), Student.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
