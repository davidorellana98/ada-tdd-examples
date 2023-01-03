package org.adaschool.tdd.controller.weather.dto;

import org.adaschool.tdd.repository.document.GeoLocation;

import java.io.Serializable;

public class NearByWeatherReportsQueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private final GeoLocation geoLocation;

    private final float distanceRangeInMeters;

    public NearByWeatherReportsQueryDto( GeoLocation geoLocation, float distanceRangeInMeters )
    {
        this.geoLocation = geoLocation;
        this.distanceRangeInMeters = distanceRangeInMeters;
    }

    public GeoLocation getGeoLocation()
    {
        return geoLocation;
    }

    public float getDistanceRangeInMeters()
    {
        return distanceRangeInMeters;
    }
}
