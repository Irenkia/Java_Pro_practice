package com.example.practice122.controller;

import com.example.practice122.entity.Device;
import com.example.practice122.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class DeviceController {
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/devices")
    public ArrayList<Device> findAllUsers() throws SQLException {
        return (ArrayList<Device>) deviceService.findAll();
    }

    @GetMapping("/device/{id}")
    public Optional<Device> findUserById(@PathVariable Integer id) throws SQLException {
        return deviceService.findById(id);
    }

    @PostMapping("/device/save")
    public ResponseEntity<Boolean> saveUser(@RequestBody Device device) throws SQLException {
        deviceService.save(device);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("device/update/{id}")
    public  ResponseEntity<Boolean> updateUserById(@PathVariable Integer id, @RequestBody Device device) throws SQLException {
        deviceService.update(device);
        return ResponseEntity.ok().body(true);
    }

    @DeleteMapping("/device/delete/{id}")
    public  ResponseEntity<Boolean> deleteUserById(@PathVariable Integer id) throws SQLException {
        deviceService.delete(id);
        return ResponseEntity.ok().body(true);
    }
}
