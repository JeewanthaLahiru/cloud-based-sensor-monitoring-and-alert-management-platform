package com.monitor.database.repository;

import com.monitor.database.model.TempData;
import com.monitor.database.model.TempDataLive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface TempDataReactiveRepository extends ReactiveMongoRepository<TempDataLive, String> {

}
