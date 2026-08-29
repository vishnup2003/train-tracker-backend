package com.traintracker.backend.controller;

import com.traintracker.backend.dto.LiveStatusDTO;
import com.traintracker.backend.service.LiveStatusService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/live")
public class LiveStatusController {

    private final LiveStatusService service;

    public LiveStatusController(LiveStatusService service) {
        this.service = service;
    }

    @GetMapping("/{trainNumber}")
    public LiveStatusDTO getLiveStatus(
            @PathVariable String trainNumber) {

        return service.getLiveStatus(trainNumber);
    }
}