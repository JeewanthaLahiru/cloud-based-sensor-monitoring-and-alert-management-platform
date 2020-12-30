package com.monitor.Authentication.Repository;

import com.monitor.Authentication.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findById(String id);
    User findByEmail(String email);
    User findByPassword(String password);

}
