package com.traintracker.backend.service;

import com.traintracker.backend.entity.Station;
import com.traintracker.backend.repository.StationRepository;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

}