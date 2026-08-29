package com.traintracker.backend.service;

import com.traintracker.backend.entity.TrainRoute;
import com.traintracker.backend.repository.TrainRouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.traintracker.backend.dto.TrainRouteDTO;

import java.util.List;

@Service
public class TrainRouteService {

    private final TrainRouteRepository repository;

    public TrainRouteService(TrainRouteRepository repository) {
        this.repository = repository;
    }

    public TrainRoute save(TrainRoute route) {
        return repository.save(route);
    }

    public List<TrainRouteDTO> getRoute(String trainNumber) {

        return repository.findByTrainTrainNumberOrderBySequenceNumber(trainNumber)
                .stream()
                .map(r -> new TrainRouteDTO(
                        r.getSequenceNumber(),
                        r.getStation().getStationCode(),
                        r.getStation().getStationName(),
                        r.getArrivalTime(),
                        r.getDepartureTime(),
                        r.getDistanceKm()
                ))
                .toList();
    }

    @Transactional
    public void deleteByTrainNumber(String trainNumber) {
        repository.deleteByTrainTrainNumber(trainNumber);
    }

}