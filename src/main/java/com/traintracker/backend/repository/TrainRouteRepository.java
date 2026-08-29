package com.traintracker.backend.repository;

import com.traintracker.backend.entity.TrainRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRouteRepository extends JpaRepository<TrainRoute, Long> {

    List<TrainRoute> findByTrainTrainNumberOrderBySequenceNumber(String trainNumber);

    void deleteByTrainTrainNumber(String trainNumber);
}