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

        com.monitor.sensor_data.Sensors Temp1 = new com.monitor.sensor_data.Sensors("0001","2018-12-12 10:20:12","45C");
        com.monitor.sensor_data.Sensors Temp2 = new com.monitor.sensor_data.Sensors("0002","2018-12-15 11:20:12","30C");
        com.monitor.sensor_data.Sensors Temp3 = new com.monitor.sensor_data.Sensors("0003","2018-12-25 13:00:45","15C");
        com.monitor.sensor_data.Sensors Temp4 = new com.monitor.sensor_data.Sensors("0002","2018-12-14 10:20:12","25C");
        com.monitor.sensor_data.Sensors Temp5 = new com.monitor.sensor_data.Sensors("0001","2018-12-13 10:20:12","18C");
        com.monitor.sensor_data.Sensors Temp6 = new com.monitor.sensor_data.Sensors("0001","2018-12-19 10:20:12","16C");




        //drop all sensors
        this.sensorRepository.deleteAll();

        //add our sensors to database
        List<com.monitor.sensor_data.Sensors> sensors = Arrays.asList(Temp1,Temp2,Temp3,Temp4,Temp5,Temp6);
        this.sensorRepository.saveAll(sensors);
    }
}
