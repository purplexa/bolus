package com.thrnio.bolus.core;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class HookHandlerDispatcher {
  private final ServiceLoader<HookHandler> handlers;

  public HookHandlerDispatcher() {
    this.handlers = ServiceLoader.load(HookHandler.class);
  }

  public List<String> dispatch(JsonNode hook) {
    List<String> topics = new ArrayList<>();
    for (HookHandler handler : this.handlers) {
      topics.addAll(handler.invoke(hook));
    }
    return topics;
  }

  public List<String> getHandlerNames() {
    List<String> names = new ArrayList<>();
    for (HookHandler handler : this.handlers) {
      names.add(handler.getClass().getName());
    }
    return names;
  }
}
