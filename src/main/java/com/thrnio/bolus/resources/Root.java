package com.thrnio.bolus.resources;

import com.codahale.metrics.annotation.Timed;
import com.thrnio.bolus.core.OptionsListing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/v0")
@Produces(MediaType.APPLICATION_JSON)
public class Root {
  public Root() {
  }

  @OPTIONS
  @Timed
  public Response listOptions() {
    OptionsListing list = new OptionsListing();
    list.setGet("List available endpoints.");
    list.setOptions("List accepted HTTP verbs.");
    return Response.status(200)
        .entity(list)
        .header("Allow", "HEAD,GET,OPTIONS")
        .build();
  }

  @GET
  @Timed
  public List<String> listEndpoints() {
    List<String> endpoints = new ArrayList<>();
    endpoints.add("/version");
    endpoints.add("/hooks");
    return endpoints;
  }
}
