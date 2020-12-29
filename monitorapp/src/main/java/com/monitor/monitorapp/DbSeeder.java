package com.monitor.monitorapp;


import org.springframework.stereotype.Component;


@Component
public class DbSeeder /*implements CommandLineRunner */{
    private final UserRepository userRepository;

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
