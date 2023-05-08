package com.example.practice122new.controller;

import com.example.practice122new.dao.DeviceDao;
import com.example.practice122new.entity.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceController {
    @Autowired
    private DeviceDao deviceDaoService;

    @PostMapping(
            path = "/addDevice",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Device> addNewDevice(@RequestBody Device device) {
        Device savedDevice = deviceDaoService.addDevice(device);
        return ResponseEntity.ok().body(savedDevice);
    }


    @GetMapping(path = "/device/all")
    public ResponseEntity<List<Device>> getAllDevices() {
        return  ResponseEntity.ok().body(deviceDaoService.getAllDevices());
    }


    @GetMapping(path = "/user/device/{id}")
    public ResponseEntity<List<Device>> getAllDevicesOfUserById(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok().body(deviceDaoService.getAllDevicesOfUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
