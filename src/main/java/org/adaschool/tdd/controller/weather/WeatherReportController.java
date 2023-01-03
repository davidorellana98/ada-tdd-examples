package org.adaschool.tdd.controller.weather;

import org.adaschool.tdd.controller.weather.dto.NearByWeatherReportsQueryDto;
import org.adaschool.tdd.controller.weather.dto.WeatherReportDto;
import org.adaschool.tdd.repository.document.WeatherReport;
import org.adaschool.tdd.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/weather" )
public class WeatherReportController {

    private final WeatherService weatherService;

    public WeatherReportController(@Autowired WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping( "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherReport findById(@PathVariable String id) {
        return weatherService.findById(id);
    }

    @GetMapping( "/reporter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<WeatherReport> findByReporterId(@PathVariable("id") String name) {
        return weatherService.findWeatherReportsByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeatherReport create(@RequestBody WeatherReportDto weatherReportDto) {
        return weatherService.report(weatherReportDto);
    }

    @PostMapping( "/nearby")
    @ResponseStatus(HttpStatus.CREATED)
    public List<WeatherReport> findNearByReports(@RequestBody NearByWeatherReportsQueryDto query) {
        return weatherService.findNearLocation(query.getGeoLocation(), query.getDistanceRangeInMeters());
    }


}
