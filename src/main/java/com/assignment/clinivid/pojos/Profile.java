package com.assignment.clinivid.pojos;

public class Profile {
    private String id;

    private Followers[] followers;

    private String imageId;

    private Location location;

    private Name name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Followers[] getFollowers ()
    {
        return followers;
    }

    public void setFollowers (Followers[] followers)
    {
        this.followers = followers;
    }

    public String getImageId ()
    {
        return imageId;
    }

    public void setImageId (String imageId)
    {
        this.imageId = imageId;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public Name getName ()
    {
        return name;
    }

    public void setName (Name name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", followers = "+followers+", imageId = "+imageId+", location = "+location+", name = "+name+"]";
    }
}
