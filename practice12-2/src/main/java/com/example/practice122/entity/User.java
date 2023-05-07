package com.example.practice122.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int user_id;
    private  String name;
    private  String surname;
    private  String phone;
    private  String gender;


}
