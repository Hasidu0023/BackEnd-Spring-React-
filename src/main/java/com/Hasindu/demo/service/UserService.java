package com.Hasindu.demo.service;

import com.Hasindu.demo.repo.userRepo;
import com.Hasindu.demo.model.User;
import com.Hasindu.demo.dto.userDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<userDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<userDTO>>(){}.getType());
    }

    // SAVE user method
    public userDTO saveUser(userDTO userDTO) {
        // Convert userDTO to User entity
        User user = modelMapper.map(userDTO, User.class);
        // Save to database
        User savedUser = userRepo.save(user);
        // Convert back to userDTO and return
        return modelMapper.map(savedUser, userDTO.class);
    }

    // UPDATE user method
    public userDTO updateUser(userDTO userDTO) {
        // Check if user exists
        userRepo.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDTO.getId()));

        // Convert DTO to Entity, save, and return
        User user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
        return userDTO;
    }

    // DELETE user method
    public String deleteUser(userDTO userDTO) {
        // Check if user exists
        userRepo.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDTO.getId()));

        // Delete the user
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return "User deleted successfully with id: " + userDTO.getId();
    }
}