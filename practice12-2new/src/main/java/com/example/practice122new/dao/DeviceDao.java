package com.example.practice122new.dao;

import com.example.practice122new.entity.Device;

import java.util.List;

public interface DeviceDao {

    public Device addDevice(Device post);

    public List<Device> getAllDevices();

    public List<Device> getAllDevicesOfUser(Integer id) throws Exception;
}
