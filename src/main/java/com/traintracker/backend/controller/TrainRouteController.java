package com.traintracker.backend.controller;

import com.traintracker.backend.dto.TrainRouteDTO;
import com.traintracker.backend.entity.TrainRoute;
import com.traintracker.backend.service.TrainRouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class TrainRouteController {

    private final TrainRouteService service;

    public TrainRouteController(TrainRouteService service) {
        this.service = service;
    }

    @PostMapping
    public TrainRoute addStop(@RequestBody TrainRoute route) {
        return service.save(route);
    }

    @GetMapping("/{trainNumber}")
    public List<TrainRouteDTO> getRoute(@PathVariable String trainNumber) {
        return service.getRoute(trainNumber);
    }

    @DeleteMapping("/train/{trainNumber}")
    public String deleteByTrain(@PathVariable String trainNumber) {
        service.deleteByTrainNumber(trainNumber);
        return "All routes deleted for train " + trainNumber;
    }
}