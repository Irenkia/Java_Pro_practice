package com.example.practice7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StudentConfig {
    @Bean
    Student student1(){
        var student1 = new Student();
        student1.setName("Bob");
        return student1;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }

    @Bean
    @Primary
    Student student2(){
        var student2 = new Student();
        student2.setName("Den");
        return student2;
    }

    @Bean(value="tom")
    Student student3(){
        var student3 = new Student();
        student3.setName("Tom");
        return student3;
    }

}
