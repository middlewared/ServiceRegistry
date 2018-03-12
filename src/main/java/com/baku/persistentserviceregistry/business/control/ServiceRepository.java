package com.baku.persistentserviceregistry.business.control;

import com.baku.persistentserviceregistry.business.entity.LocationStats;
import com.baku.persistentserviceregistry.business.entity.Service;
import com.baku.persistentserviceregistry.business.entity.ServiceLocation;
import static com.baku.persistentserviceregistry.business.entity.ServiceLocationStatus.UNKNOWN;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Singleton;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import org.apache.commons.lang3.tuple.Triple;

@Singleton
public class ServiceRepository {

    private final ConcurrentHashMap<String, List<Triple>> services = new ConcurrentHashMap<>();

    public Response createService(Service service) throws URISyntaxException {
        if (services.contains(service.getServiceName())) {
            return Response.status(CONFLICT).header("x-reason", "Object already exists").build();
        }

        services.put(service.getServiceName(), new LinkedList<>());
        return Response.created(new URI("ServiceRegistry/resources/services/" + service.getServiceName())).build();
    }

    public JsonArray getAllServiceNames() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        services.entrySet().forEach((entry) -> {
            arrayBuilder.add(entry.getKey());
        });
        return arrayBuilder.build();
    }

    public void addLocationToService(String serviceName, String uri) {
        List<Triple> urisWithStats = services.get(serviceName);

        for (Triple uriWithStats : urisWithStats) {
            if (((ServiceLocation) uriWithStats.getLeft()).getLocationUri().equals(uri)) {
                return;
            }
        }

        urisWithStats.add(Triple.of(new ServiceLocation(uri), new LocationStats(), UNKNOWN));
    }

    public List<Triple> getAllServicesUris() {
        List<Triple> combinedUrisList = new LinkedList<>();
        services.values().forEach((uriWithStatsAndStatus) -> {
            combinedUrisList.addAll(uriWithStatsAndStatus);
        });
        return combinedUrisList;
    }
}
