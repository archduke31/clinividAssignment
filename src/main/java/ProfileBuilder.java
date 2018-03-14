package com.assignment.clinivid.test;

import com.assignment.clinivid.pojos.*;

import java.util.ArrayList;

public class ProfileBuilder implements CompleteProfile {
    private String input;
    private Profile completeProfile;
    //constructor
    public ProfileBuilder(String input){
        this.input=input;
        completeProfile=new Profile();
    }
    public Profile getCompleteUserProfile(){
        return completeProfile;
    }
    public void setName(Name name) {
        completeProfile.setName(name);
    }
    public void setId(String id) {
        completeProfile.setId(id);
    }
    public void setImageId(String imageId) {
        completeProfile.setImageId(imageId);
    }
    public void setLocation(Location location) {
        completeProfile.setLocation(location);
    }
    public void setFollowers(Followers[] followersList) {
        completeProfile.setFollowers(followersList);
    }
    //Parse input
    public void parse(){
        if(followersExists()){
            String userProfileDetails=input.split("\\*\\*")[0]; //* is a reserved character in regexes, so escaping it
            String followersList=input.split("\\*\\*followers\\|")[1];
            setUserProfile(userProfileDetails);
            setFollowers(getFollowers(followersList));
        }else {
            setUserProfile(this.input);
        }
    }
    private boolean followersExists(){
        if(this.input.indexOf("**followers")==-1)
            return false;
        return true;
    }
    public Followers[] getFollowers(String followersList) {
        String[] followerSet=followersList.split("@@\\|");
        Followers[] followers=new Followers[followerSet.length];
        for(int i=0;i<followerSet.length;i++){
            String[] followerProfile=followerSet[i].split("\\|");
            followers[i]=setFollower(followerProfile);
        }
        return followers;
    }
    private Followers setFollower(String[] followerDetails){
        Followers follower=new Followers();
        if(followerDetails.length>=1)
            follower.setId(followerDetails[0]);
        if(followerDetails.length>=2)
            follower.setName(getUserName(followerDetails[1]));
        if(followerDetails.length>=3)
            follower.setLocation(getLocation(followerDetails[2]));
        if(followerDetails.length==4)
            follower.setImageId(followerDetails[3]);
        return follower;
    }

    public void setUserProfile(String userProfileDetails){
        String[] detailedUserProfile=userProfileDetails.split("\\|"); // | is a reserved character in regexes, so escaping it
        if(detailedUserProfile.length>=2)
            setId(detailedUserProfile[1]);
        if(detailedUserProfile.length>=3)
            setName(getUserName(detailedUserProfile[2]));
        if(detailedUserProfile.length>=4)
            setLocation(getLocation(detailedUserProfile[3]));
        if(detailedUserProfile.length==5)
            setImageId(detailedUserProfile[4]);
    }
    private Location getLocation(String locationWithTags) {
        Location location=new Location();
        ArrayList<String> locationWithoutTags=removeTags(locationWithTags);
        location.setCoords(getCoords(locationWithoutTags.get(1),locationWithoutTags.get(2)));
        location.setName(locationWithoutTags.get(0));
        return location;
    }
    private Coords getCoords(String longitude,String lat){
        Coords coords=new Coords();
        if(longitude.equals(null)||longitude.equals(""))
            coords.setLong(null);
        else
            coords.setLong(Double.parseDouble(longitude));
        if(lat.equals(null)||lat.equals(""))
            coords.setLat(null);
        else
            coords.setLat(Double.parseDouble(lat));
        return coords;
    }
    private Name getUserName(String nameWithTags){
        ArrayList<String> nameWithoutTags=removeTags(nameWithTags);
        Name name=new Name();
        name.setFirst(nameWithoutTags.get(0));
        name.setMiddle(nameWithoutTags.get(1));
        name.setLast(nameWithoutTags.get(2));
        return name;
    }
    private ArrayList<String> removeTags(String stringWithTagsToRemove){
        ArrayList<String> tagFreeStrings=new ArrayList<String>();
        StringBuilder str=new StringBuilder();
        char prev=' ';
        for(char c:stringWithTagsToRemove.toCharArray()){
            if(c=='<');
            else if(c=='>'){
                if(prev!='>') {
                    tagFreeStrings.add(str.toString());
                    str.setLength(0);
                }
            }else{
                str.append(c);
            }
            prev=c;
        }
        return tagFreeStrings;
    }

}
