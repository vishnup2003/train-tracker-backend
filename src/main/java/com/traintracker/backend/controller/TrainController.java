package com.traintracker.backend.controller;

import com.traintracker.backend.entity.Train;
import com.traintracker.backend.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    public Train create(@RequestBody Train train) {
        return trainService.save(train);
    }

    @GetMapping
    public List<Train> getAll() {
        return trainService.getAll();
    }

    @GetMapping("/number/{number}")
    public Train getByNumber(@PathVariable String number) {
        return trainService.getByNumber(number);
    }

    @GetMapping("/search")
    public List<Train> search(@RequestParam String name) {
        return trainService.searchByName(name);
    }

    @PutMapping("/{id}")
    public Train update(@PathVariable Long id, @RequestBody Train train) {
        return trainService.update(id, train);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        trainService.delete(id);
        return "Train deleted successfully";
    }
}