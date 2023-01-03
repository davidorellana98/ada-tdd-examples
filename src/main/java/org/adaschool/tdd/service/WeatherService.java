package org.adaschool.tdd.service;

import org.adaschool.tdd.controller.weather.dto.WeatherReportDto;
import org.adaschool.tdd.repository.document.GeoLocation;
import org.adaschool.tdd.repository.document.WeatherReport;

import java.util.List;

public interface WeatherService {

    WeatherReport findById(String id);
    List<WeatherReport> findWeatherReportsByName(String reporter);
    WeatherReport report(WeatherReportDto weatherReportDto);
    List<WeatherReport> findNearLocation(GeoLocation geoLocation, float distanceRangeInMeters);

}
