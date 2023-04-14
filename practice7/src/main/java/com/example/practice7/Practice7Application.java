package com.example.practice7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.sql.SQLOutput;

@SpringBootApplication
public class Practice7Application {

    public static void main(String[] args) {

        SpringApplication.run(Practice7Application.class, args);
        var context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student s1 = context.getBean("student1",Student.class);
        System.out.println(s1.getName());

        String str = context.getBean(String.class);
        System.out.println(str);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);

        Student s2 = context.getBean("student2",Student.class);
        System.out.println(s2.getName());

        Student s3 = context.getBean(Student.class);
        System.out.println(s3.getName());

        Student s4 = context.getBean("tom",Student.class);
        System.out.println(s4.getName());

    }

}
