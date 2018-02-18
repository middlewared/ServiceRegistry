package com.baku.persistentserviceregistry.business.control;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class ServiceStatusTrackerScheduler {

    @Inject
    ServiceStatusTracker serviceStatusTracker;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void initCheck() {
        serviceStatusTracker.checkServicesStatus();
    }
}
