package com.traintracker.backend.controller;

import com.traintracker.backend.dto.TrainSearchDTO;
import com.traintracker.backend.service.TrainSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
@CrossOrigin("*")
public class TrainSearchController {

    private final TrainSearchService trainSearchService;

    public TrainSearchController(TrainSearchService trainSearchService) {
        this.trainSearchService = trainSearchService;
    }

    @GetMapping("/between")
    public List<TrainSearchDTO> searchTrains(
            @RequestParam String source,
            @RequestParam String destination
    ) {
        return trainSearchService.searchTrains(source, destination);
    }
}