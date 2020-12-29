package com.monitor.Authentication.configuration;


import com.monitor.Authentication.Repository.UserRepository;
import org.springframework.stereotype.Component;


@Component
public class DbSeeder {

    public DbSeeder(UserRepository userRepository) {
    }
}
