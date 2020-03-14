package com.ms.resources;

import com.ms.models.Movie;
import com.ms.services.MoviesService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    private static final Logger LOG = LoggerFactory.getLogger(MovieResource.class);


    @Inject
    @RestClient
    MoviesService moviesService;

    Map<String, Movie> movieMap = new HashMap<String, Movie>() {{
        put("1", new Movie("1", "War", "Yash Raj Films"));
        put("2", new Movie("2", "Kabir Singh", "T-Series"));
        put("3", new Movie("3", "Uri: The Surgical Strike", "RSVP Movies"));
        put("4", new Movie("4", "Bharat", "Salman Khan Films"));
        put("5", new Movie("5", "Mission Mangal", "Cape of Good Films"));
        put("6", new Movie("6", "Housefull 4", "Fox Star Studios"));
    }};


    @PermitAll
    @GET
    @Path("/{movieId}")
    public Movie list(final @PathParam("movieId") String movieId) {
        LOG.info(" Request received for movie id : "+movieId);
        return moviesService.getByImdbId(movieId);
    }
}
