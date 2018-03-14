package com.assignment.clinivid.pojos;

public class Coords
{
    private Double longitude=null;

    private Double lat=null;
    public Double getLong()
    {
        return longitude;
    }

    public void setLong (Double longitude)
    {
        this.longitude = longitude;
    }

    public Double getLat ()
    {
        return lat;
    }

    public void setLat (Double lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [long = "+(this.longitude)+", lat = "+(this.lat)+"]";
    }
}
