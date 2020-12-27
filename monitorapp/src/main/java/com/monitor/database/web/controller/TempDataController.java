package com.monitor.database.web.controller;

import com.monitor.database.model.TempData;
import com.monitor.database.repository.TempDataRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/tempdata")
public class TempDataController {

    private TempDataRepository tempDataRepository;

    public TempDataController(TempDataRepository tempDataRepository) {
        this.tempDataRepository = tempDataRepository;
    }

    @GetMapping("/all")
    public List<TempData> getAll() {
        return this.tempDataRepository.findAll();
    }


    @PostMapping("/value")
    public void post(@RequestBody TempData tempData) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        tempData.setDate(dateFormat.format(cal.getTime()));
        this.tempDataRepository.save(tempData);
    }

}
