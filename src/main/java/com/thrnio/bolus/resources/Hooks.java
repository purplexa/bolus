package com.thrnio.bolus.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thrnio.bolus.core.HookHandlerDispatcher;
import com.thrnio.bolus.api.OptionsListing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/v0/hooks")
@Produces(MediaType.APPLICATION_JSON)
public class Hooks {
  private final HookHandlerDispatcher dispatcher;

  public Hooks() {
    this.dispatcher = new HookHandlerDispatcher();
  }

  @OPTIONS
  @Timed
  public Response listOptions() {
    OptionsListing list = new OptionsListing.Builder()
        .setGetDescription("List available hook handlers.")
        .setOptionsDescription("List accepted HTTP verbs.")
        .setPostDescription("Parse the data in the body and push it onto the queue.")
        .build();
    return Response.status(200)
        .entity(list)
        .header("Allow", "HEAD,GET,POST,OPTIONS")
        .build();
  }

  @GET
  @Timed
  public List<String> listHandlers() {
    return this.dispatcher.getHandlerNames();
  }

  @POST
  @Timed
  public Response submitHook(String rawData) throws java.io.IOException {
    ObjectMapper om = new ObjectMapper();
    List<String> topics = this.dispatcher.dispatch(om.readTree(rawData));
    return Response.status(204)
        .build();
  }
}
