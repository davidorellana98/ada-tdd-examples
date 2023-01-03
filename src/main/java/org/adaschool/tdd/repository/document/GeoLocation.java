package org.adaschool.tdd.repository.document;

public class GeoLocation
{

    private final double lat;

    private final double lng;

    public GeoLocation( double lat, double lng )
    {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat()
    {
        return lat;
    }

    public double getLng()
    {
        return lng;
    }
}
