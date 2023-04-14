package com.example.practice73;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestController {
    @GetMapping("/home")
    public String test(){
        return "home";
    }

    public MyTestController() {
        System.out.println("we are ready!");
    }

    @PostConstruct
    public void  init(){
        System.out.println("constructed!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroyed?");
    }

}
