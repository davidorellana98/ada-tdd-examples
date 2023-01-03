package org.adaschool.tdd;

import org.adaschool.tdd.controller.weather.dto.WeatherReportDto;
import org.adaschool.tdd.exception.WeatherReportNotFoundException;
import org.adaschool.tdd.repository.WeatherReportRepository;
import org.adaschool.tdd.repository.document.GeoLocation;
import org.adaschool.tdd.repository.document.WeatherReport;
import org.adaschool.tdd.service.MongoWeatherService;
import org.adaschool.tdd.service.WeatherService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongoWeatherServiceTest {

    WeatherService weatherService;

    @Mock
    WeatherReportRepository repository;

    @BeforeAll()
    public void setup() {
        weatherService = new MongoWeatherService(repository);
    }

    @Test
    @Order(1)
    void findWeatherReportById() {

        String weatherReportId = "awae-asd45-1dsad";
        double lat = 4.7110;
        double lng = 74.0721;
        GeoLocation location = new GeoLocation(lat, lng);
        WeatherReport weatherReport = new WeatherReport(location, 35f, 22f, "tester", new Date() );
        when(repository.findById(weatherReportId)).thenReturn(Optional.of(weatherReport));
        WeatherReport foundWeatherReport = weatherService.findById(weatherReportId);
        Assertions.assertEquals(weatherReport, foundWeatherReport);
    }

    @Test
    @Order(2)
    void createWeatherReportCallsSaveOnRepository() {

        double lat = 4.7110;
        double lng = 74.0721;
        GeoLocation location = new GeoLocation(lat, lng);
        WeatherReportDto weatherReportDto = new WeatherReportDto(location, 35f, 22f, "tester", new Date());
        weatherService.report(weatherReportDto);
        verify(repository).save(any(WeatherReport.class));
    }

    /*@Test
    void weatherReportIdNotFoundTest() {

        String weatherReportId = "dsawe1fasdasdoooq123";
        when(repository.findById(weatherReportId)).thenReturn(Optional.empty());
        Assertions.assertThrows(WeatherReportNotFoundException.class, () -> {
            weatherService.findById( weatherReportId );
        });
    }*/
}
