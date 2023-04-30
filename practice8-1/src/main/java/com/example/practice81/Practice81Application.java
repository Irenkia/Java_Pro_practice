package com.example.practice81;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.SQLOutput;
import java.util.Set;

@SpringBootApplication
public class Practice81Application implements CommandLineRunner  {
    private final GenericApplicationContext context;

    public Practice81Application(GenericApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyConfiguration.class);
        ctx.refresh();

        MyBean mb1 = ctx.getBean(MyBean.class);
        MyBean mb2 = ctx.getBean(MyBean.class);
        Student st1 = ctx.getBean(Student.class);
        Student st2 = ctx.getBean(Student.class);

        ctx.close();


        SpringApplication.run(Practice81Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        context.registerBean("com.example.practice81.TimeService", TimeService.class, TimeService::new);
        var timeService = (TimeService) context.getBean(TimeService.class);
        System.out.println(timeService.getNow());

    }

}
