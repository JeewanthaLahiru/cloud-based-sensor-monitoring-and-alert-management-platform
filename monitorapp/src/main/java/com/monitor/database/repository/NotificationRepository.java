/*package com.monitor.database.repository;

import com.monitor.database.model.Notification;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends ReactiveCrudRepository<Notification, String> {

    @Tailable
    Flux<Notification> findWithTailableCursorBy();

}*/
