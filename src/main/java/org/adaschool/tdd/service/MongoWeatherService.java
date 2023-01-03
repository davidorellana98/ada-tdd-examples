package org.adaschool.tdd.service;

import org.adaschool.tdd.controller.weather.dto.NearByWeatherReportsQueryDto;
import org.adaschool.tdd.controller.weather.dto.WeatherReportDto;
import org.adaschool.tdd.repository.WeatherReportRepository;
import org.adaschool.tdd.repository.document.GeoLocation;
import org.adaschool.tdd.repository.document.WeatherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MongoWeatherService implements WeatherService {

    private final WeatherReportRepository repository;

    public MongoWeatherService(@Autowired WeatherReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public WeatherReport findById(String id) {
        Optional<WeatherReport> findWeatherReport = repository.findById(id);
        if (findWeatherReport.isPresent()) {
            return findWeatherReport.get();
        }
        return null;
    }

    @Override
    public List<WeatherReport> findWeatherReportsByName(String reporter) {
        return (List<WeatherReport>) repository.findAllById(Collections.singleton(reporter));
    }

    @Override
    public WeatherReport report(WeatherReportDto weatherReportDto) {
        WeatherReport weatherReport = new WeatherReport(weatherReportDto);
        return repository.save(weatherReport);
    }

    @Override
    public List<WeatherReport> findNearLocation(GeoLocation geoLocation, float distanceRangeInMeters) {
        NearByWeatherReportsQueryDto finNearByWeatherReports = new NearByWeatherReportsQueryDto(geoLocation, distanceRangeInMeters);
        WeatherReport findWeatherReport = new WeatherReport(finNearByWeatherReports);
        List<WeatherReport> weatherReportList = Collections.singletonList(findWeatherReport);
        return repository.saveAll(weatherReportList);
    }
}
