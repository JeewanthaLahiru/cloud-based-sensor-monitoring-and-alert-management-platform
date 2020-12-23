package com.monitor.monitorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class UserController {

    UserRepository UserRepository;

    @Autowired
    public UserController(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @PostMapping("/User")
    public void addUser(@RequestBody User user) {

        System.out.println("Adding a new user to the system");

        UserRepository.addUser(user);



    }

    @GetMapping("/User")
    public User getUser(@RequestParam String email) {
        System.out.println("Getting the user. userId: " + email);


        return UserRepository.getUser(email);

    }
}
