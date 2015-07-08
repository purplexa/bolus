package com.thrnio.bolus.resources;

import com.codahale.metrics.annotation.Timed;
import com.thrnio.bolus.core.OptionsListing;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/v0/version")
@Produces(MediaType.APPLICATION_JSON)
public class Version {
  public Version() {
  }

  @OPTIONS
  @Timed
  public Response listOptions() {
    OptionsListing list = new OptionsListing();
    list.setGet("List version.");
    list.setOptions("List accepted HTTP verbs.");
    return Response.status(200)
        .entity(list)
        .header("Allow", "HEAD,GET,OPTIONS")
        .build();
  }

  @GET
  @Timed
  public Map version() {
    Map<String, String> version = new HashMap<>();
    version.put("version", getClass().getPackage().getImplementationVersion());
    return version;
  }
}
