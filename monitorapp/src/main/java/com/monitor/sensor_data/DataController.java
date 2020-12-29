package com.monitor.sensor_data;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sensors")
public class DataController {
    private SensorDataRepository sensorRepository;

    public DataController(SensorDataRepository hotelRepository) {
        this.sensorRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Sensors> getAll() {
        List<Sensors> sensors = this.sensorRepository.findAll();
        return sensors;
    }

    @GetMapping("address/{find}")
    public List<Sensors> getById(@PathVariable("find") String id){
       List<Sensors> sensor=this.sensorRepository.find(id);
        return sensor;
    }
}
