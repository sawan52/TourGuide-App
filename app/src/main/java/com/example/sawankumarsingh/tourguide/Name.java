package com.example.sawankumarsingh.tourguide;

public class Name {

    // create a constant variable to store an integer value for Image  presence
    private static final int NO_IMAGE_PROVIDED = -1;
    // create a variable to store Location Name
    private String mLocationName;
    // create a variable to store Location Address
    private String mLocationAddress;
    // create a variable to store Location geoLocation Url
    private String mUrl;
    // create a variable to store Location Image and initially assign it a constant variable value -1 to make that no image is present
    private int mLocationImage = NO_IMAGE_PROVIDED;

    // create a Name constructor to initialize the object
    public Name(String locationName, String locationAddress, int locationImage, String url) {
        mLocationName = locationName;
        mLocationAddress = locationAddress;
        mLocationImage = locationImage;
        mUrl = url;
    }

    // create a getter method to get location name and return it
    public String getLocationName() {
        return mLocationName;
    }

    // create a getter method to get location address and return it
    public String getLocationAddress() {
        return mLocationAddress;
    }

    // create a getter method to get location image and return it
    public int getLocationImage() {
        return mLocationImage;
    }

    // create a getter method to check whether a Image is present or not and then return it
    public boolean hasImage() {
        return mLocationImage != NO_IMAGE_PROVIDED;
    }

    // create a getter method to get geoLocationUrl and return it
    public String getUrl() {
        return mUrl;
    }
}
