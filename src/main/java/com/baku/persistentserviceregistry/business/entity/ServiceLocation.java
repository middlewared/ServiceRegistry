package com.baku.persistentserviceregistry.business.entity;

public class ServiceLocation {

    private String locationUri;

    public ServiceLocation(String locationUri) {
        this.locationUri = locationUri;
    }

    public String getLocationUri() {
        return locationUri;
    }

    public void setLocationUri(String locationUri) {
        this.locationUri = locationUri;
    }
}
