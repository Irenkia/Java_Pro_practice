package com.example.practice82;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("test","Travels!");
        modelAndView.setViewName("home");
        return modelAndView;
    }

}