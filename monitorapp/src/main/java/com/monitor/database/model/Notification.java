package com.monitor.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;

    private String sensor;

    private String time;

    private String temp;

    public Notification(String time, String temp,String sensor) {
        this.time = time;
        this.temp = temp;
        this.sensor=sensor;
    }

}