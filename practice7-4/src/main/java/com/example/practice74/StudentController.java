package com.example.practice74;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping("list")
    public ModelAndView list() {
        return new ModelAndView("catalog/students/list",
                Map.of("students", this.studentRepository.findAll()), HttpStatus.OK);
    }
}
