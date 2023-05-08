package com.example.practice122new.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "devices")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer deviceId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Integer userId;

    private  String name;
    private  String macaddr;
}
