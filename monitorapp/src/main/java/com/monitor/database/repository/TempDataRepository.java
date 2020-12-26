package com.monitor.database.repository;


import com.monitor.database.model.TempData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempDataRepository extends MongoRepository<TempData, String> {
}
