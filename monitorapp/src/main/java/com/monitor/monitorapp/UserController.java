package com.monitor.monitorapp;

import com.monitor.monitorapp.utility.JWTUtility;
//import com.sun.el.parser.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequestWrapper;
import javax.xml.bind.DatatypeConverter;
import java.util.List;
//import java.util.Optional;

import static javax.crypto.Cipher.SECRET_KEY;
//import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;
//import static org.springframework.web.servlet.function.RouterFunctions.route;

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
            User user1=this.userRepository.findByEmail(user.getEmail());
            User user2=this.userRepository.findByPassword(user.getPassword());
            if (user1 == null && user2 == null) {
                return new String[]{"Wrong Email and Password"};
             }
            if (user1 == null) {
                return new String[]{"Wrong Email"};
            }
            if (user2 == null) {
                return new String[]{"Wrong Password"};
            }
            final String token=jwtUtility.generateToken(user2.getId());
            return new JwtResponse(token);
    }
    @GetMapping("/now")
    public static Claims  getCurrentUser(String jwt){
            //This line will throw an exception if it is not a signed JWS (as expected)
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(String.valueOf(SECRET_KEY)))
                    .parseClaimsJws(jwt).getBody();
            return claims;
    }

}
