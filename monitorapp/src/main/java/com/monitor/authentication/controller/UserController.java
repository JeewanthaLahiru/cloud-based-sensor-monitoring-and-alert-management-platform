package com.monitor.authentication.controller;

import com.monitor.authentication.entity.AuthRequest;
import com.monitor.authentication.entity.MessageResponse;
import com.monitor.authentication.entity.User;
import com.monitor.authentication.repository.UserRepository;
import com.monitor.authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(@RequestHeader("Authorization") String authorization) {

        String token = authorization.substring(7);
        System.out.println(token);
        String username = jwtUtil.extractUsername(token);
        return username;
    }

    @GetMapping("/ggg")
    public String welcomeM() {
        return "frfd";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public Object register(@RequestBody User user) throws Exception {

        User existsByUsername = userRepository.existsByEmail(user.getEmail());

        if(existsByUsername != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is already taken!"));
        } else {
            this.userRepository.save(user);
            //return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
                );
            } catch (Exception ex) {
                throw new Exception("invalid email/password");
            }
            return jwtUtil.generateToken(user.getEmail());
        }

    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println(authRequest.getEmail());
        System.out.println(authRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid email/password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }
}

