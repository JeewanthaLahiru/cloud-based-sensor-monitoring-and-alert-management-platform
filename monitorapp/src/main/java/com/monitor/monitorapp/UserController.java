package com.monitor.monitorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/User")
public class UserController {

    private UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//add user
    @PostMapping("/add")
    public void insert(@RequestBody User user) {
        this.userRepository.insert(user);
    }
//get all users list
    @GetMapping("/all")
    public List<User> getAll(){
        List<User> users =this.userRepository.findAll();
        return users;
    }
//delete user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")String id){
        this.userRepository.deleteById(id);
    }
//find user by email


}
