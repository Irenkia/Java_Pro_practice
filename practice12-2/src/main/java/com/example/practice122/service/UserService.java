package com.example.practice122.service;

import com.example.practice122.dao.Dao;
import com.example.practice122.entity.User;
import com.example.practice122.dao.UserDao;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
//@Service
@NoArgsConstructor(force=true)
public class UserService implements DaoService<Integer, User>{
//    @Autowired
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }
}
