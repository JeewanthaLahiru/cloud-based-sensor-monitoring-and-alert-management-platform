package com.monitor.database.web.controller;

import com.monitor.database.model.Notification;
import com.monitor.database.model.TempData;
import com.monitor.database.repository.NotificationReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notification/mongodb")
public class NotificationReactiveController {

    /*private NotificationService notificationService;*/
    private NotificationReactiveRepository notificationReactiveRepository;

    @Autowired
    public NotificationReactiveController(/*NotificationService notificationService, */NotificationReactiveRepository notificationReactiveRepository) {
        //this.notificationService = notificationService;
        this.notificationReactiveRepository = notificationReactiveRepository;
    }

    @PostMapping("/send")
    public Mono<Notification> post(@RequestBody TempData tempData) {
        String data_value = tempData.getData_value();
        String date = tempData.getDate();
        Notification notification = new Notification(date, data_value);
        System.out.println("listening");
        return this.notificationReactiveRepository.save(notification);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Notification> getByTailing() {
        Flux<Notification> stream = notificationReactiveRepository.findByTime("24");
        Disposable subscription = stream.doOnNext(System.out::println).subscribe();
        return stream;
    }

}
