package com.example.UserManagementService.resources;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserManagementService.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
}