package com.example.practice122.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private Integer user_id;
    private  String name;
    private  String surname;
    private  String phone;
}
