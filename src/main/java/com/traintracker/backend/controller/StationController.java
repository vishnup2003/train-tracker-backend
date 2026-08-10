package com.traintracker.backend.controller;

import com.traintracker.backend.dto.ImportSummaryResponse;
import com.traintracker.backend.entity.Station;
import com.traintracker.backend.service.StationCsvService;
import com.traintracker.backend.service.StationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;
    private final StationCsvService stationCsvService;

    public StationController(StationService stationService, StationCsvService stationCsvService) {
        this.stationService = stationService;
        this.stationCsvService = stationCsvService;
    }

    @PostMapping
    public Station saveStation(@RequestBody Station station) {
        return stationService.saveStation(station);
    }

    @PostMapping("/import")
    public ImportSummaryResponse importStations() {
        return stationCsvService.importStations();
    }

    @PostMapping("/upload")
    public ImportSummaryResponse uploadStations(@RequestParam("file") MultipartFile file) {
        return stationCsvService.importStations(file);
    }

    @GetMapping
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }

    @GetMapping("/code/{stationCode}")
    public Station getByStationCode(@PathVariable String stationCode) {
        return stationService.getByStationCode(stationCode);
    }

    @GetMapping("/search")
    public List<Station> searchByName(@RequestParam String name) {
        return stationService.searchByName(name);
    }

    @PutMapping("/{id}")
    public Station updateStation(@PathVariable Long id, @RequestBody Station station){
        return stationService.updateStation(id, station);
    }

    @DeleteMapping("/{id}")
    public String deleteStation(@PathVariable Long id){
        stationService.deleteStation(id);
        return "Station Deleted Successfully";
    }

}