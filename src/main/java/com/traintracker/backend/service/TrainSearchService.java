package com.traintracker.backend.service;

import com.traintracker.backend.dto.TrainSearchDTO;
import com.traintracker.backend.entity.Train;
import com.traintracker.backend.repository.TrainRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSearchService {

    private final TrainRouteRepository trainRouteRepository;

    public TrainSearchService(TrainRouteRepository trainRouteRepository) {
        this.trainRouteRepository = trainRouteRepository;
    }

    public List<TrainSearchDTO> searchTrains(String source, String destination) {

        List<Train> trains =
                trainRouteRepository.findTrainsBetweenStations(source, destination);

        return trains.stream()
                .map(train -> new TrainSearchDTO(
                        train.getTrainNumber(),
                        train.getTrainName()
                ))
                .toList();
    }

}
