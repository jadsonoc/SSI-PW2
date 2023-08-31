package edu.ifrs;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/checkout")
public class Checkout {
    
    @Inject
    @RestClient
    IPayment service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Invoice confirm(){
        return service.confirmPayment("123455","100");
    }

}
