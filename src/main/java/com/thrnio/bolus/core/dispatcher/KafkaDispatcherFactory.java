package com.thrnio.bolus.core.dispatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thrnio.bolus.core.HookDispatcher;
import com.thrnio.bolus.core.HookDispatcherFactory;

import java.util.Map;

public class KafkaDispatcherFactory implements HookDispatcherFactory {
  private Map<String, Object> configuration;

  @Override
  public String dispatcherConfigName() {
    return "kafka";
  }

  @Override
  public HookDispatcherFactory configure(Map<String, Object> config) {
    configuration = config;
    return this;
  }

  @Override
  public HookDispatcher build() {
    return new KafkaDispatcher(this.configuration);
  }

  private static class KafkaDispatcher implements HookDispatcher {

    public KafkaDispatcher(Map<String, Object> configuration) {

    }

    @Override
    public Runnable getRunner(String handler, JsonNode hook) {
      return new Runner(handler, hook);
    }

    private class Runner implements Runnable {
      private final String handler;
      private final JsonNode hook;

      public Runner(String handler, JsonNode hook) {
        this.handler = handler;
        this.hook = hook;
      }

      @Override
      public void run() {
        System.out.println("Handler: " + handler);
        try {
          System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(hook));
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
