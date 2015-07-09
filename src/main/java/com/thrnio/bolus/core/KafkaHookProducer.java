package com.thrnio.bolus.core;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.List;
import java.util.Map;

public final class KafkaHookProducer {
  private static KafkaHookProducer instance;
  private final KafkaProducer producer;

  private KafkaHookProducer(Map<String, Object> config) {
    this.producer = new KafkaProducer(config);
  }

  public static void setConfig(Map<String, Object> config) throws Exception {
    if (instance == null) {
      instance = new KafkaHookProducer(config);
    }
    else {
      throw new Exception();
    }
  }

  public static KafkaHookProducer getInstance() {
    return instance;
  }

  public void post(JsonNode hook, List<String> topics) {
    // send data to kafka
  }
}
