package com.thrnio.bolus;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import java.util.Map;

public class BolusConfiguration extends Configuration {
  private Map<String, Object> kafka;

  @JsonProperty
  public Map<String, Object> getKafka() {
    return kafka;
  }

  @JsonProperty
  public void setKafka(Map<String, Object> kafka) {
    this.kafka = kafka;
  }
}