package com.example.practice122new.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
//    @OneToMany(targetEntity = Device.class)
//    @JoinColumn(name = "user_id")
    private  Integer userId;
    private  String name;
    private  String surname;
    private  String phone;
    private  String gender;


}
