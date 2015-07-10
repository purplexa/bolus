package com.thrnio.bolus.core;

import com.fasterxml.jackson.databind.JsonNode;

public interface HookDispatcher {
  Runnable getRunner(String handler, JsonNode hook);
}
