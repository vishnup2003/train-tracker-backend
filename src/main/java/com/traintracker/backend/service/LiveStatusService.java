package com.traintracker.backend.service;

import com.traintracker.backend.dto.LiveStatusDTO;
import org.springframework.stereotype.Service;
import com.traintracker.backend.entity.Train;
import com.traintracker.backend.entity.TrainRoute;
import com.traintracker.backend.repository.TrainRepository;
import com.traintracker.backend.repository.TrainRouteRepository;

import java.util.List;

import java.time.LocalDateTime;

@Service
public class LiveStatusService {

    private final TrainRepository trainRepository;
    private final TrainRouteRepository trainRouteRepository;

    public LiveStatusService(TrainRepository trainRepository,
                             TrainRouteRepository trainRouteRepository) {
        this.trainRepository = trainRepository;
        this.trainRouteRepository = trainRouteRepository;
    }

    public LiveStatusDTO getLiveStatus(String trainNumber) {

        Train train = trainRepository.findByTrainNumber(trainNumber)
                .orElseThrow(() -> new RuntimeException("Train not found"));

        List<TrainRoute> routes =
                trainRouteRepository.findByTrainTrainNumberOrderBySequenceNumber(trainNumber);

        if (routes.size() < 2) {
            throw new RuntimeException("Not enough route data");
        }

        int currentIndex =
                (int) (System.currentTimeMillis() / 10000) % (routes.size() - 1);

        TrainRoute current = routes.get(currentIndex);
        TrainRoute next = routes.get(currentIndex + 1);

        return new LiveStatusDTO(
                train.getTrainNumber(),
                train.getTrainName(),

                current.getStation().getStationCode(),
                current.getStation().getStationName(),

                next.getStation().getStationCode(),
                next.getStation().getStationName(),

                10,
                LocalDateTime.now()
        );
    }
}