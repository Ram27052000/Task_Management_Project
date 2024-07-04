package com.example.TaskManagement.service;

import com.example.TaskManagement.models.User;
import com.example.TaskManagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(int id) throws Exception {
        boolean existsById = userRepository.existsById(id);
        if(!existsById){
             throw new Exception("User Id not exists");
        }
        return userRepository.findById(id);
    }
}
