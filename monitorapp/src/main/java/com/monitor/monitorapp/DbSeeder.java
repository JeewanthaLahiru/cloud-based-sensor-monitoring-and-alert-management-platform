package com.monitor.monitorapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder /*implements CommandLineRunner */{
    private UserRepository userRepository;

    public DbSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
/*
    @Override
    public void run(String... strings) throws Exception {
        User Chanaka = new User(
                "Chanaka",
                "chanaka@gmail.com",
                "cmax12",
                "0767025709",
                "Email"
        );

        User Jeewantha = new User(
                "jeewantha",
                "jeewantha@gmail.com",
                "jeewa12",
                "074583825709",
                "Text"
        );

        this.userRepository.deleteAll();


        List<User> users = Arrays.asList(Chanaka, Jeewantha);
        this.userRepository.saveAll(users);
    }*/
}
