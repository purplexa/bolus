package com.thrnio.bolus;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import java.util.Map;

public class BolusConfiguration extends Configuration {
  private Map<String, Map<String, Object>> dispatchers;

  @JsonProperty
  public Map<String, Map<String, Object>> dispatchers() {
    return dispatchers;
  }

  @JsonProperty
  public void setDispatchers(Map<String, Map<String, Object>> dispatchers) {
    this.dispatchers = dispatchers;
  }
}
