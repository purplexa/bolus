package com.thrnio.bolus.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OptionsVerb {
  private String description;
  private List<OptionsVerbParameter> parameters;

  public OptionsVerb() {
  }

  public OptionsVerb(String description) {
    this.description = description;
  }

  public OptionsVerb(String description, List<OptionsVerbParameter> parameters) {
    this(description);
    this.parameters = parameters;
  }

  @JsonProperty
  public String getDescription() {
    return this.description;
  }

  @JsonProperty
  public List<OptionsVerbParameter> getParameters() {
    return this.parameters;
  }
}
