package com.thrnio.bolus.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thrnio.bolus.api.OptionsListing;
import com.thrnio.bolus.core.HookDispatcher;
import com.thrnio.bolus.core.HookDispatcherList;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Path("/v0/hooks{handler : (/(\\w+))?}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Hooks {
  private final ExecutorService dispatcherQueue;
  private final HookDispatcherList dispatchers;

  public Hooks(ExecutorService dispatcherQueue, HookDispatcherList dispatchers) {
    this.dispatcherQueue = dispatcherQueue;
    this.dispatchers = dispatchers;
  }

  @OPTIONS
  @Timed
  public Response listOptions() {
    OptionsListing list = new OptionsListing.Builder()
        .setGetDescription("List defined hook handler endpoints.")
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
    return new ArrayList<>();
  }

  @POST
  @Timed
  public Response submitHook(@PathParam("handler") String handler, String rawData) throws java.io.IOException {
    handler = StringUtils.removeStart(handler, "/");
    ObjectMapper om = new ObjectMapper();
    JsonNode jsonHook = om.readTree(rawData);
    for (HookDispatcher dispatcher : dispatchers) {
      dispatcherQueue.submit(dispatcher.getRunner(handler, jsonHook));
    }
    return Response.status(204)
        .build();
  }
}
