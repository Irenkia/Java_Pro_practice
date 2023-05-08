package com.example.practice122new.dao;

import com.example.practice122new.entity.User;
import com.example.practice122new.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<User> getUser(Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new Exception("User not found");
        }
        return user;
    }
}
