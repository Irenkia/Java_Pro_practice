package com.example.practice122new.dao;

import com.example.practice122new.entity.Device;
import com.example.practice122new.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceDaoImpl implements DeviceDao{
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }


    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }


    @Override
    public List<Device> getAllDevicesOfUser(Integer id) throws Exception {
        return deviceRepository.getAllDevicesOfUser(id);
    }
}
