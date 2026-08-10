package com.traintracker.backend.service;

import com.opencsv.CSVReader;
import com.traintracker.backend.dto.ImportSummaryResponse;
import com.traintracker.backend.entity.Station;
import com.traintracker.backend.repository.StationRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@Service
public class StationCsvService {

    private final StationRepository stationRepository;

    public StationCsvService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    // Import from internal resources/stations.csv
    public ImportSummaryResponse importStations() {

        int imported = 0;
        int skipped = 0;
        int totalRows = 0;

        try {

            ClassPathResource resource =
                    new ClassPathResource("stations.csv");

            CSVReader csvReader = new CSVReader(
                    new InputStreamReader(resource.getInputStream())
            );

            List<String[]> rows = csvReader.readAll();

            totalRows = rows.size() - 1;

            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                String stationCode = row[0];

                if (stationRepository.existsByStationCode(stationCode)) {
                    skipped++;
                    continue;
                }

                Station station = new Station();

                station.setStationCode(row[0]);
                station.setStationName(row[1]);
                station.setState(row[2]);
                station.setZone(row[3]);
                station.setDivision(row[4]);
                station.setLatitude(Double.parseDouble(row[5]));
                station.setLongitude(Double.parseDouble(row[6]));

                stationRepository.save(station);

                imported++;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ImportSummaryResponse(
                totalRows,
                imported,
                skipped,
                "Import completed successfully"
        );
    }

    // Import from uploaded CSV file (Postman/Admin panel)
    public ImportSummaryResponse importStations(MultipartFile file) {

        int imported = 0;
        int skipped = 0;
        int totalRows = 0;

        try (CSVReader csvReader = new CSVReader(
                new InputStreamReader(file.getInputStream()))) {

            List<String[]> rows = csvReader.readAll();

            totalRows = rows.size() - 1;

            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                String stationCode = row[0];

                if (stationRepository.existsByStationCode(stationCode)) {
                    skipped++;
                    continue;
                }

                Station station = new Station();

                station.setStationCode(row[0]);
                station.setStationName(row[1]);
                station.setState(row[2]);
                station.setZone(row[3]);
                station.setDivision(row[4]);
                station.setLatitude(Double.parseDouble(row[5]));
                station.setLongitude(Double.parseDouble(row[6]));

                stationRepository.save(station);

                imported++;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ImportSummaryResponse(
                totalRows,
                imported,
                skipped,
                "File uploaded and imported successfully"
        );
    }
}