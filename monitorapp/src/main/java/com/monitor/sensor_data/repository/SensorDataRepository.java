package com.monitor.sensor_data.repository;

import com.monitor.sensor_data.entity.Sensors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends MongoRepository<Sensors,String> {
    Sensors findSensorsById(String sensor_id);

    @Query(value = "{sensor_id:?0}")
    List<Sensors> find(String id);

}
