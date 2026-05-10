package com.Hasindu.demo.controller;

import com.Hasindu.demo.dto.userDTO;
import com.Hasindu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<userDTO> getUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/adduser")
    public userDTO saveUser(@RequestBody userDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateuser")
    public userDTO updateUser(@RequestBody userDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    // DELETE user method
    @DeleteMapping("/deleteuser")
    public String deleteUser(@RequestBody userDTO userDTO) {
        return userService.deleteUser(userDTO);
    }
}