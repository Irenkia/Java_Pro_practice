package com.example.practice122.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private  int device_id;
    private int user_id;
    private  String name;
    private  String macaddr;

}
