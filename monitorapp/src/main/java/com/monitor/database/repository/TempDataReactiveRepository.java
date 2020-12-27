package com.monitor.database.repository;

import com.monitor.database.model.TempData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface TempDataReactiveRepository extends ReactiveMongoRepository<TempData, String> {

}
