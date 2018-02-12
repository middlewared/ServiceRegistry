package com.baku.persistentserviceregistry.business.entity;

import java.math.BigDecimal;

public class LocationStats {

    private int hits;
    private BigDecimal avgResponseTime;

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public BigDecimal getAvgResponseTime() {
        return avgResponseTime;
    }

    public void setAvgResponseTime(BigDecimal avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
    }
}
