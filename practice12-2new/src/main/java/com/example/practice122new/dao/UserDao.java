package com.example.practice122new.dao;

import com.example.practice122new.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public User saveUser(User user);


    public List<User> getAllUsers();


    public void deleteUser(Integer id);


    public Optional<User> getUser(Integer id) throws Exception;
}
