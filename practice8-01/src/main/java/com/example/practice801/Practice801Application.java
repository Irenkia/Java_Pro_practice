package com.example.practice801;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Practice801Application {

    public static void main(String[] args) {

 //       SpringApplication.run(Practice801Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyContext.class);
        ctx.refresh();

        MyContext test = new MyContext();
        Class cl1 = test.getClass();
        System.out.println(cl1);


    }

}
