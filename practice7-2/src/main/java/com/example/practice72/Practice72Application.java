package com.example.practice72;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Practice72Application {

    public static void main(String[] args) {

        //SpringApplication.run(Practice72Application.class, args);
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Student s = context.getBean(Student.class);
        System.out.println(s);
        System.out.println(s.getName());
        s.setName("Bob");
        System.out.println(s.getName());
    }

}
