package com.example.practice122new.repository;

import com.example.practice122new.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public  interface UserRepository extends JpaRepository<User, Integer> {
}
//public  interface UserRepository extends CrudRepository<User, Integer> {
//}