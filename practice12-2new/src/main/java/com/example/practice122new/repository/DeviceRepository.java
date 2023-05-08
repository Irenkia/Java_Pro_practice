package com.example.practice122new.repository;

import com.example.practice122new.entity.Device;
import com.example.practice122new.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public  interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query(value = "SELECT * FROM device WHERE user_id = :id", nativeQuery = true)
    List<Device> getAllDevicesOfUser(Integer id);
}
//public  interface DeviceRepository extends CrudRepository<User, Integer> {
//    @Query(value = "SELECT * FROM device WHERE user_id = :id", nativeQuery = true)
//    List<Device> getAllDevicesOfUser(Integer id);
//}