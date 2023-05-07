package com.example.practice122.service;

import com.example.practice122.dao.DeviceDao;
import com.example.practice122.entity.Device;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor(force=true)
public class DeviceService implements DaoService<Integer, Device> {
    private DeviceDao deviceDao;

    public DeviceService(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }


    @Override
    public List<Device> findAll() {
        return deviceDao.findAll();
    }

    @Override
    public Optional<Device> findById(Integer id) {
        return deviceDao.findById(id);
    }

    @Override
    public Device save(Device device) {
        return deviceDao.save(device);
    }

    @Override
    public void update(Device device) {
        deviceDao.update(device);
    }

    @Override
    public boolean delete(Integer id) {
        return deviceDao.delete(id);
    }
}
