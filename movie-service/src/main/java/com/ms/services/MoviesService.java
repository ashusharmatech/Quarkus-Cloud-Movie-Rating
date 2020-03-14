package com.ms.services;

import com.ms.models.Movie;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@RegisterRestClient
public interface MoviesService {

    @GET
    @Path("/")
    @Produces("application/json")
    Movie getByImdbId(@QueryParam(value = "i") String imdbId);


}
