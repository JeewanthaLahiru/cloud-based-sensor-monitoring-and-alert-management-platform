package com.monitor.sensor_data;

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
@Document(collection = "sensorData")
public class Sensors {
    @Id
    private String id;
    private String sensor_id;
    private String date;
    private String data_value;

    /*public Sensors(String sensor_id, String date, String data_value) {
        this.sensor_id = sensor_id;
        this.date = date;
        this.data_value = data_value;
    }*/
}
