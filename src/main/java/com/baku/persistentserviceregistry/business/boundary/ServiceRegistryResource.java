package com.baku.persistentserviceregistry.business.boundary;

import com.baku.persistentserviceregistry.business.control.ServiceRepository;
import com.baku.persistentserviceregistry.business.entity.Service;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

@Path("services")
@Stateless
public class ServiceRegistryResource {

    @Inject
    ServiceRepository serviceRepository;

    @POST
    @Consumes(APPLICATION_JSON)
    public Response addService(Service service) throws URISyntaxException {
        try {
            System.err.println(service.toString());
            serviceRepository.createService(service);
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public JsonArray getServicesList() {
        return serviceRepository.getAllServiceNames();
    }
    
//    @PUT
//    public void addServiceLocation(@QueryParam("serviceName") String serviceName, @QueryParam("uri") String uri) {
//        serviceRepository.addLocationToService(serviceName, serviceName);
//    } 
}
