package com.monitor.database.web.controller;

import com.monitor.database.model.TempData;
import com.monitor.database.repository.TempDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class TempDataController {

    private TempDataRepository tempDataRepository;

    public TempDataController(TempDataRepository tempDataRepository) {
        this.tempDataRepository = tempDataRepository;
    }

    @GetMapping("/all")
    public List<TempData> getAll() {
        return this.tempDataRepository.findAll();
    }
}
