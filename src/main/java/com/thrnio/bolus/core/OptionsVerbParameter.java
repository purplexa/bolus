package com.thrnio.bolus.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionsVerbParameter {
  @NotEmpty
  private final String name;

  @NotEmpty
  private final String type;

  @NotEmpty
  private Boolean required;

  private String description;

  public OptionsVerbParameter(String name, String type) {
    this(name, type, false);
  }

  public OptionsVerbParameter(String name, String type, Boolean required) {
    this.name = name;
    this.type = type;
    this.required = required;
  }

  public OptionsVerbParameter(String name, String type, Boolean required, String description) {
    this(name, type, required);
    this.description = description;
  }

  @JsonProperty
  public String getName() {
    return this.name;
  }

  @JsonProperty
  public String getType() {
    return type;
  }

  @JsonProperty
  public Boolean getRequired() {
    return required;
  }

  @JsonProperty
  public String getDescription() {
    return description;
  }
}
