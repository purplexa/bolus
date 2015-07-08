package com.thrnio.bolus.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thrnio.bolus.core.JsonHook;
import com.thrnio.bolus.core.OptionsListing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/v0/hooks")
@Produces(MediaType.APPLICATION_JSON)
public class Hooks {
  public Hooks() {
  }

  @OPTIONS
  @Timed
  public Response listOptions() {
    OptionsListing list = new OptionsListing();
    list.setGet("List available hook handlers.");
    list.setOptions("List accepted HTTP verbs.");
    list.setPost("Parse the data in the body and push it onto the queue.");
    return Response.status(200)
        .entity(list)
        .header("Allow", "HEAD,GET,PUT,OPTIONS")
        .build();
  }

  @GET
  @Timed
  public List<String> listHandlers() {
    List<String> list = new ArrayList<>();
    return list;
  }

  @POST
  @Timed
  public Response submitHook(String rawData) throws java.io.IOException {
    JsonHook hook = new JsonHook(rawData);
    return Response.status(204)
        .build();
  }
}
