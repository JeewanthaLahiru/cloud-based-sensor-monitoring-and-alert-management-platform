package com.monitor.database.service;

import com.monitor.database.model.Notification;
import com.monitor.database.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
public class NotificationService {

    private ReactiveMongoTemplate reactiveMongoTemplate;
    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(ReactiveMongoTemplate reactiveMongoTemplate, NotificationRepository notificationRepository) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.notificationRepository = notificationRepository;
    }

    @PostConstruct
    public void configure() {
        reactiveMongoTemplate.collectionExists("notifications").subscribe();
    }

    public Mono<Notification> save(Notification notification) {
        return this.notificationRepository.save(notification);
    }

    public Flux<Notification> getAllByTailing() {
        return this.notificationRepository.findWithTailableCursorBy();
    }

    public Flux<Notification> getAllNormally() {
        return this.notificationRepository.findAll();
    }

}
