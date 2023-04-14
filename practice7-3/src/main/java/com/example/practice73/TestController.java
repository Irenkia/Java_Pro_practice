package com.example.practice73;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "test")
public class TestController {
    @GetMapping("/home")
    public String test(){
        return "home";
    }

}
