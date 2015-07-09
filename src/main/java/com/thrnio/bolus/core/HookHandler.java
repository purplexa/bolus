package com.thrnio.bolus.core;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface HookHandler {
  List<String> invoke(JsonNode hook);
}
