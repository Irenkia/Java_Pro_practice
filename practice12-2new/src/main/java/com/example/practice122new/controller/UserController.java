package com.example.practice122new.controller;

import com.example.practice122new.dao.UserDao;
import com.example.practice122new.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserDao userDaoService;

    @PostMapping(
            path = "/addUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User savedUser = userDaoService.saveUser(user);
        return ResponseEntity.ok().body(savedUser);
    }


    @GetMapping(path = "/user/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return  ResponseEntity.ok().body(userDaoService.getAllUsers());
    }


    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok().body(userDaoService.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @DeleteMapping(path = "/user/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userDaoService.deleteUser(id);
        return  ResponseEntity.ok().body("User deleted");
    }
}
