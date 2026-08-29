package com.traintracker.backend.repository;

import com.traintracker.backend.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {

    Optional<Train> findByTrainNumber(String trainNumber);

    List<Train> findByTrainNameContainingIgnoreCase(String trainName);
}