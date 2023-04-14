package com.example.practice72;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Robert";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
