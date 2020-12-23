package com.monitor.monitorapp;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class InMemoryUserRepository implements UserRepository {

    Map<String,User> UserMap = new HashMap<>();

    public InMemoryUserRepository () {
        User kamal = new User("kamal","kamal@gmail.com","kam90","13123123","Email");
        User nimal = new User("nimal", "nimal@gmail.com","nim34","2342342","Audio call");
        UserMap.put("kamal@gmail.com", kamal);
        UserMap.put("nimal@gmail.com", nimal);
    }




    @Override
    public User getUser(String email) {

        System.out.println(email);
        return UserMap.get(email);

    }

    @Override
    public void addUser(User User) {
        UserMap.put(User.getEmail(),User);
        System.out.println(User.getName()+User.getEmail()+User.getPhone());
    }

}

