package com.example.practice81;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component("person")
@MyContainerScan
public class Person {
    private Student student;
    private int age;

    public Person() {
        System.out.println("Person instance created");

    }

    public Person(Student student) {
        System.out.println("Person created");
        System.out.println("Student hashcode = " + student.hashCode());
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
