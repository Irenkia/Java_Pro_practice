package com.example.practice81;

import org.springframework.stereotype.Component;

//@Component("student")
@MyContainerScan
public class Student {
    private String name;

    public Student() {
        System.out.println("Student instance created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
