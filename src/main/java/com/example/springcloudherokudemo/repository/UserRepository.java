package com.example.springcloudherokudemo.repository;


import com.example.springcloudherokudemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
