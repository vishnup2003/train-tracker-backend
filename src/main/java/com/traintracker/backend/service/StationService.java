package com.traintracker.backend.service;

import com.traintracker.backend.entity.Station;
import com.traintracker.backend.exception.StationAlreadyExistsException;
import com.traintracker.backend.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station saveStation(Station station) {
        if (stationRepository.existsByStationCode(station.getStationCode())) {
            throw new StationAlreadyExistsException("Station code already exists");
        }
        return stationRepository.save(station);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(Long id) {
        return stationRepository.findById(id).orElse(null);
    }

    public Station getByStationCode(String stationCode) {
        return stationRepository .findByStationCode(stationCode) .orElse(null);
    }

    public List<Station> searchByName(String name) {
        return stationRepository .findByStationNameContainingIgnoreCase(name);
    }

    public Station updateStation(Long id, Station updatedStation) {
        updatedStation.setId(id);
        return stationRepository.save(updatedStation);
    }

    public void deleteStation(Long id){
        stationRepository.deleteById(id);
    }

}