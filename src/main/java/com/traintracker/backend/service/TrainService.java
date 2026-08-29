package com.traintracker.backend.service;

import com.traintracker.backend.entity.Train;
import com.traintracker.backend.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train save(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> getAll() {
        return trainRepository.findAll();
    }

    public Train getByNumber(String number) {
        return trainRepository.findByTrainNumber(number)
                .orElseThrow(() -> new RuntimeException("Train not found"));
    }

    public List<Train> searchByName(String name) {
        return trainRepository.findByTrainNameContainingIgnoreCase(name);
    }

    public Train update(Long id, Train updated) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found"));

        train.setTrainNumber(updated.getTrainNumber());
        train.setTrainName(updated.getTrainName());
        train.setTrainType(updated.getTrainType());
        train.setTotalCoaches(updated.getTotalCoaches());
        train.setActive(updated.getActive());

        return trainRepository.save(train);
    }

    public void delete(Long id) {
        trainRepository.deleteById(id);
    }
}