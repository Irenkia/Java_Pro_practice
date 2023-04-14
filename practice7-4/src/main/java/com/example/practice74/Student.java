package com.example.practice74;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private UUID id;
    private String name;
    private  String surname;
}
