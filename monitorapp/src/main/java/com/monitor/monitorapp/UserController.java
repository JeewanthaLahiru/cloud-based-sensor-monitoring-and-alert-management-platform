package com.monitor.monitorapp;

import com.monitor.monitorapp.utility.JWTUtility;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/User")
public class UserController {

    private final UserRepository userRepository;
    private final JWTUtility jwtUtility;

    @Autowired
    public UserController(UserRepository userRepository, JWTUtility jwtUtility) {
        this.userRepository = userRepository;
        this.jwtUtility = jwtUtility;
    }

    //add user
    @PostMapping("/add")
    public Object insert(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail())!=null) {
            return new String[]{"Email already registered"};
        }
            this.userRepository.insert(user);
            final String token = jwtUtility.generateToken(user.getEmail(), user.getPassword());
            return new JwtResponse(token);
    }
    //find user by email
    @PostMapping( "/login")
    public Object login(@RequestBody User user) {
        final String token=jwtUtility.generateToken(user.getEmail(), user.getPassword());
        return new JwtResponse(token);
    }

    @GetMapping("/currentUser")
    public Object user(@RequestHeader("Authorization") String token){
        String token1 =jwtUtility.getEmailFromToken(token);
        String password = token1.substring(token1.lastIndexOf(",") + 1);
        String email = token1.substring(0, token1.indexOf(','));

        if (userRepository.findByEmail(email)!=null){
            if (userRepository.findByPassword(password)!=null){
                return  userRepository.findByPassword(password);
            }
            return new String[]{"Wrong Password"};
        }
        return new String[]{"Wrong Email"};
    }

}