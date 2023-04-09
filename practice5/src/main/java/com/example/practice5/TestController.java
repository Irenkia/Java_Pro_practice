package com.example.practice5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {
    @GetMapping("/view")
    public String view() {
        return "index.html";
    }
}
