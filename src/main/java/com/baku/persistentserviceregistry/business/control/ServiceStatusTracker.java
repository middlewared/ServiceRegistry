package com.baku.persistentserviceregistry.business.control;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.lang3.tuple.Triple;

@Stateless
public class ServiceStatusTracker {

    @Inject
    ServiceRepository serviceRepository;

    public void updateServicesStatuses() {
        List<Triple> allServicesUris = serviceRepository.getAllServicesUris();
        for (Triple serviceUriWithStatsAndStatus : allServicesUris) {
            String serviceUri = serviceUriWithStatsAndStatus.getLeft().toString();
            
            //TODO add heartbeat check in order to determine service status
        }
    }
}
