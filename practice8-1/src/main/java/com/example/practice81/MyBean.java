package com.example.practice81;
@MyContainerScan
@MyComponent
public class MyBean {
    public MyBean() {
        System.out.println("MyBean instance created");
    }

    public String init() {
        return "MyBean Resources Initialized";
    }
}
