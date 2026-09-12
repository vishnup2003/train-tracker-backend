package com.traintracker.backend.repository;

import com.traintracker.backend.entity.Train;
import com.traintracker.backend.entity.TrainRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainRouteRepository extends JpaRepository<TrainRoute, Long> {

    List<TrainRoute> findByTrainTrainNumberOrderBySequenceNumber(String trainNumber);

    void deleteByTrainTrainNumber(String trainNumber);

    @Query("""
            SELECT DISTINCT tr1.train
            FROM TrainRoute tr1
            JOIN TrainRoute tr2
            ON tr1.train.id = tr2.train.id
            WHERE tr1.station.stationCode = :source
            AND tr2.station.stationCode = :destination
            AND tr1.sequenceNumber < tr2.sequenceNumber
            """)
    List<Train> findTrainsBetweenStations(
            @Param("source") String source,
            @Param("destination") String destination
    );
}