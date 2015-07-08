package com.thrnio.bolus.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionsListing {
  private OptionsVerb options;
  private OptionsVerb get;
  private OptionsVerb head;
  private OptionsVerb post;
  private OptionsVerb put;
  private OptionsVerb delete;
  private OptionsVerb patch;

  @JsonProperty("OPTIONS")
  public OptionsVerb getOptions() {
    return options;
  }

  @JsonProperty("GET")
  public OptionsVerb getGet() {
    return get;
  }

  @JsonProperty("HEAD")
  public OptionsVerb getHead() {
    return head;
  }

  @JsonProperty("POST")
  public OptionsVerb getPost() {
    return post;
  }

  @JsonProperty("PUT")
  public OptionsVerb getPut() {
    return put;
  }

  @JsonProperty("DELETE")
  public OptionsVerb getDelete() {
    return delete;
  }

  @JsonProperty("PATCH")
  public OptionsVerb getPatch() {
    return patch;
  }

  public OptionsListing setOptions(String description) {
    this.options = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setOptions(String description, List<OptionsVerbParameter> parameters) {
    this.options = new OptionsVerb(description, parameters);
    return this;
  }

  public OptionsListing setGet(String description) {
    this.get = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setGet(String description, List<OptionsVerbParameter> parameters) {
    this.get = new OptionsVerb(description, parameters);
    return this;
  }

  public OptionsListing setHead(String description) {
    this.head = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setHead(String description, List<OptionsVerbParameter> parameters) {
    this.head = new OptionsVerb(description, parameters);
    return this;
  }

  public OptionsListing setPost(String description) {
    this.post = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setPost(String description, List<OptionsVerbParameter> parameters) {
    this.post = new OptionsVerb(description, parameters);
    return this;
  }

  public OptionsListing setPut(String description) {
    this.put = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setPut(String description, List<OptionsVerbParameter> parameters) {
    this.put = new OptionsVerb(description, parameters);
    return this;
  }

  public OptionsListing setDelete(String description) {
    this.delete = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setDelete(String description, List<OptionsVerbParameter> parameters) {
    this.delete = new OptionsVerb(description, parameters);
    return this;
  }

  public OptionsListing setPatch(String description) {
    this.patch = new OptionsVerb(description);
    return this;
  }

  public OptionsListing setPatch(String description, List<OptionsVerbParameter> parameters) {
    this.patch = new OptionsVerb(description, parameters);
    return this;
  }
}
