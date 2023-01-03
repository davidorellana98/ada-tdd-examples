package org.adaschool.tdd.controller.weather.dto;

import org.adaschool.tdd.repository.document.GeoLocation;

import java.io.Serializable;
import java.util.Date;

public class WeatherReportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    GeoLocation geoLocation;

    double temperature;

    double humidity;

    String reporter;

    Date created;

    public WeatherReportDto( GeoLocation geoLocation, double temperature, double humidity, String reporter,
                             Date created )
    {
        this.geoLocation = geoLocation;
        this.temperature = temperature;
        this.humidity = humidity;
        this.reporter = reporter;
        this.created = created;
    }

    public GeoLocation getGeoLocation()
    {
        return geoLocation;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public double getHumidity()
    {
        return humidity;
    }

    public String getReporter()
    {
        return reporter;
    }

    public Date getCreated()
    {
        return created;
    }


}
