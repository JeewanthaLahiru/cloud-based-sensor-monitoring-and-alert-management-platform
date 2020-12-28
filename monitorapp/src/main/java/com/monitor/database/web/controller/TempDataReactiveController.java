/*package com.monitor.database.web.controller;


import com.monitor.database.model.TempData;
import com.monitor.database.model.TempDataLive;
import com.monitor.database.repository.TempDataReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/tempdata/live")
public class TempDataReactiveController {

    private TempDataReactiveRepository tempDataReactiveRepository;

    @Autowired
    public TempDataReactiveController(TempDataReactiveRepository tempDataReactiveRepository) {
        this.tempDataReactiveRepository = tempDataReactiveRepository;
    }

    @GetMapping("/all")
    public Flux<TempDataLive> getByTailing() {
        Flux<TempDataLive> tempDataFlux = this.tempDataReactiveRepository.findAll();
        return tempDataFlux;
    }


}*/
