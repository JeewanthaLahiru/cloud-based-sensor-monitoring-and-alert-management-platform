package com.monitor.database.web.controller;

import com.monitor.database.model.Notification;
import com.monitor.database.repository.NotificationReactiveRepository;
import com.monitor.sensor_data.entity.Sensors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notification/mongodb")
public class NotificationReactiveController {


    private NotificationReactiveRepository notificationReactiveRepository;


    @Autowired
    public NotificationReactiveController(NotificationReactiveRepository notificationReactiveRepository) {
        this.notificationReactiveRepository = notificationReactiveRepository;
    }

    @PostMapping("/send")
    public Mono<Notification> post(@RequestBody Sensors sensors) {
        String data_value = sensors.getData_value();
        String date = sensors.getDate();
        String sensor= sensors.getSensor_id();
        Notification notification = new Notification(date, data_value,sensor);
        return this.notificationReactiveRepository.save(notification);
    }
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Notification> getByTailing(){
        Flux<Notification> stream = notificationReactiveRepository.findByTime("24");
        Disposable subscription = stream.doOnNext(System.out::println).subscribe();
        return stream;
    }

}
