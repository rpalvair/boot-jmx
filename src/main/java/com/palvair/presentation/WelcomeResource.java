package com.palvair.presentation;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/")
@ManagedResource
public class WelcomeResource {

    private String name = "Ruddy";

    @ManagedAttribute
    public void setName(String name) {
        this.name = name;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello() {
        return Response.ok("Welcome " + name)
                .build();
    }
}
