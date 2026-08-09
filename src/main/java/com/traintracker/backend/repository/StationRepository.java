package com.traintracker.backend.repository;

import com.traintracker.backend.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {
    Optional<Station> findByStationCode(String stationCode);
    List<Station> findByStationNameContainingIgnoreCase(String stationName);
    boolean existsByStationCode(String stationCode);
}