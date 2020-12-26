package com.monitor.database.repository;


import com.monitor.database.model.Notification;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface NotificationReactiveRepository extends ReactiveMongoRepository<Notification, String> {

    @Tailable
    @Query("{ 'temp' : {$gte: ?0} }")
    Flux<Notification> findByTime(String temp);

}
