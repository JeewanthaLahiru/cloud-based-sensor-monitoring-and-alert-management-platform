package com.monitor.sensor_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Sensor_Seeder implements CommandLineRunner {
    private com.monitor.sensor_data.SensorDataRepository sensorRepository;

    @Autowired
    public Sensor_Seeder(com.monitor.sensor_data.SensorDataRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        com.monitor.sensor_data.Sensors Temp1 = new com.monitor.sensor_data.Sensors("0001", "2018-12-12 10:20:12", "45C");
        com.monitor.sensor_data.Sensors Temp2 = new com.monitor.sensor_data.Sensors("0001", "2018-12-15 11:20:12", "30C");
        com.monitor.sensor_data.Sensors Temp3 = new com.monitor.sensor_data.Sensors("0001", "2018-12-25 13:00:45", "15C");
        com.monitor.sensor_data.Sensors Temp4 = new com.monitor.sensor_data.Sensors("0001", "2018-12-14 10:20:12", "25C");
        com.monitor.sensor_data.Sensors Temp5 = new com.monitor.sensor_data.Sensors("0001", "2018-12-13 10:20:12", "18C");
        com.monitor.sensor_data.Sensors Temp6 = new com.monitor.sensor_data.Sensors("0001", "2018-12-19 10:20:12", "16C");

        com.monitor.sensor_data.Sensors Hum1 = new com.monitor.sensor_data.Sensors("0002", "2018-12-14 10:20:13", "12%");
        com.monitor.sensor_data.Sensors Hum2 = new com.monitor.sensor_data.Sensors("0002", "2018-12-15 10:20:20", "25%");
        com.monitor.sensor_data.Sensors Hum3 = new com.monitor.sensor_data.Sensors("0002", "2018-12-17 10:20:12", "50%");
        com.monitor.sensor_data.Sensors Hum4 = new com.monitor.sensor_data.Sensors("0002", "2018-12-15 10:22:12", "60%");
        com.monitor.sensor_data.Sensors Hum5 = new com.monitor.sensor_data.Sensors("0002", "2018-12-20 10:11:12", "90%");
        com.monitor.sensor_data.Sensors Hum6 = new com.monitor.sensor_data.Sensors("0002", "2018-12-11 10:10:12", "45%");

        com.monitor.sensor_data.Sensors Pre1 = new com.monitor.sensor_data.Sensors("0003", "2018-11-14 10:22:13", "100P");
        com.monitor.sensor_data.Sensors Pre2 = new com.monitor.sensor_data.Sensors("0003", "2018-10-14 10:19:13", "100P");
        com.monitor.sensor_data.Sensors Pre3 = new com.monitor.sensor_data.Sensors("0003", "2018-02-14 11:18:13", "99P");
        com.monitor.sensor_data.Sensors Pre4 = new com.monitor.sensor_data.Sensors("0003", "2018-11-14 12:20:13", "99P");
        com.monitor.sensor_data.Sensors Pre5 = new com.monitor.sensor_data.Sensors("0003", "2018-12-14 13:20:13", "105P");
        com.monitor.sensor_data.Sensors Pre6 = new com.monitor.sensor_data.Sensors("0003", "2018-15-14 14:20:13", "104P");
        com.monitor.sensor_data.Sensors Pre7 = new com.monitor.sensor_data.Sensors("0003", "2018-17-14 08:20:13", "106P");



        //drop all sensors
        this.sensorRepository.deleteAll();

        //add our sensors to database
        List<com.monitor.sensor_data.Sensors> sensors = Arrays.asList(Temp1, Temp2, Temp3, Temp4, Temp5, Temp6,Hum1,Hum2,Hum3,Hum4,Hum5,Hum6,Pre1,Pre2,Pre3,Pre4,Pre5,Pre6,Pre7);
        this.sensorRepository.saveAll(sensors);
    }
}
