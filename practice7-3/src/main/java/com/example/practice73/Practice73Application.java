package com.example.practice73;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.practice73.Practice73Application.text;

@SpringBootApplication
@MyAnnotation(name = text)
@Configuration
public class Practice73Application {
    @Bean
    public String string(){
        return "Hy there!";
//        return new String("Hello there!");
    }

    @Bean(name = "hello")
    public String string2(){
        return "Hello there!";
    }
    public static final String text = "x";

    public static void main(String[] args) {

        var clazz = Practice73Application.class;
        var annotations = clazz.getDeclaredAnnotations();
        System.out.println(annotations);

        var context = SpringApplication.run(Practice73Application.class, args);
        var bean = context.getBean(TestController.class);
        System.out.println(bean);

    }

}
