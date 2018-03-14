package com.assignment.clinivid.pojos;

public class Location
{
    private Coords coords;

    private String name;

    public Coords getCoords ()
    {
        return coords;
    }
    public void setCoords (Coords coords)
    {
        this.coords = coords;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [coords = "+coords+", name = "+name+"]";
    }
}
