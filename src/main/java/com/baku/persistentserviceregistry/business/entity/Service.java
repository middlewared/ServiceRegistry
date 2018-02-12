package com.baku.persistentserviceregistry.business.entity;

import java.util.List;

public class Service {

    private String serviceName;
    private List<ServiceLocation> serviceLocations;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<ServiceLocation> getServiceLocations() {
        return serviceLocations;
    }

    public void setServiceLocations(List<ServiceLocation> serviceLocations) {
        this.serviceLocations = serviceLocations;
    }   

    @Override
    public String toString() {
        return "Service{" + "serviceName=" + serviceName + ", serviceLocations=" + serviceLocations + '}';
    }
}
