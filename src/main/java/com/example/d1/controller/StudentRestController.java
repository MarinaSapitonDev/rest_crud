package com.example.d1.controller;

import com.example.d1.Driver;
import com.example.d1.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

 @GetMapping("/students")
    public Student getStudent(){
        Driver driver = new Driver();
       return driver.returnStudentJSON();
    }
}
