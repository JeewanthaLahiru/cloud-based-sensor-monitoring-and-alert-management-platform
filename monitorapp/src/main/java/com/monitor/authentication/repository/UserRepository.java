package com.monitor.authentication.repository;


import com.monitor.authentication.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


    @Query("{'email' : ?0}")
    User findByEmail(String username);

    @Query("{'email' : ?0}")
    User existsByEmail(String username);
}
