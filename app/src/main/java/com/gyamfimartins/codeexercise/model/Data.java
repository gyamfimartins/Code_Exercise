package com.gyamfimartins.codeexercise.model;

public class Data {
    private String url,startDate,endDate,name,icon,objType;
    private Venue venue;
    private boolean loginRequired;

    public String getUrl() {
        return url;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getObjType() {
        return objType;
    }

    public Venue getVenue() {
        return venue;
    }

    public boolean isLoginRequired() {
        return loginRequired;
    }
}
