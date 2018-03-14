package com.assignment.clinivid.test;

import com.assignment.clinivid.pojos.*;

public interface CompleteProfile {
    public void setName(Name name);
    public void setId(String id);
    public void setImageId(String imageId);
    public void setLocation(Location location);
    public void setFollowers(Followers[] followersList);
}
