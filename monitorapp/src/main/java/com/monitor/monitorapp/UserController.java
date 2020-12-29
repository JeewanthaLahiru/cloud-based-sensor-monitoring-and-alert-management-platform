/*
package com.monitor.monitorapp;


import com.monitor.monitorapp.utility.JWTUtility;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.util.List;

import static javax.crypto.Cipher.SECRET_KEY;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/User")
public class UserController {

    private UserRepository userRepository;
    private final JWTUtility jwtUtility;

    @Autowired
    public UserController(UserRepository userRepository, JWTUtility jwtUtility) {
        this.userRepository = userRepository;
        this.jwtUtility = jwtUtility;
    }

//add user
    @PostMapping("/add")
    public Object insert(@RequestBody User user) {
        this.userRepository.insert(user);
        User user1=this.userRepository.findByEmail(user.getEmail());
        final String token=jwtUtility.generateToken(user1.getId());
        return new JwtResponse(token);
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
    @PostMapping( "/login")
    public Object login(@RequestBody User user) {
        String email = user.getEmail();
        final String token=jwtUtility.generateToken(email);
        return new JwtResponse(token);
    }

    @PostMapping("/now")
    public static Claims  getCurrentUser(String jwt){
            //This line will throw an exception if it is not a signed JWS (as expected)
        System.out.println(jwt);
            */
/*Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(String.valueOf(SECRET_KEY)))
                    .parseClaimsJws(jwt).getBody();
            return claims;*//*

        return null;
    }

}
*/
