package com.example.practice122.controller;

import com.example.practice122.entity.User;
import com.example.practice122.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

//@Controller
@RestController
public class UserController {
//    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ArrayList<User> findAllUsers() throws SQLException {
        return (ArrayList<User>) userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUserById(@PathVariable Integer id) throws SQLException {
        return userService.findById(id);
    }

    @PostMapping("/user/save")
    public ResponseEntity<Boolean> saveUser(@RequestBody User user) throws SQLException {
        userService.save(user);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("user/update/{id}")
    public  ResponseEntity<Boolean> updateUserById(@PathVariable Integer id, @RequestBody User user) throws SQLException {
        userService.update(user);
        return ResponseEntity.ok().body(true);
    }

    @DeleteMapping("/user/delete/{id}")
    public  ResponseEntity<Boolean> deleteUserById(@PathVariable Integer id) throws SQLException {
        userService.delete(id);
        return ResponseEntity.ok().body(true);
    }
}
