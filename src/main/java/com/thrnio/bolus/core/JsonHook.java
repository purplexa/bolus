package com.thrnio.bolus.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonHook {
  private JsonNode hookBody;

  public JsonHook(String rawData) throws java.io.IOException {
    ObjectMapper om = new ObjectMapper();
    JsonNode hookBody = om.readTree(rawData);
    System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(hookBody));
    this.hookBody = hookBody;
  }
}
