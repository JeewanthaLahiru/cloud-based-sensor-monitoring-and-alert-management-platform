/*
package com.monitor.monitorapp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Query("{ 'email' : ?0 }")
    User findByEmail(String email);

    @Query("{ 'password' : ?0 }")
    User findByPassword(String password);

    @Query("{ 'id' : ?0 }")
    Optional<User> findById(String id);

}
*/
