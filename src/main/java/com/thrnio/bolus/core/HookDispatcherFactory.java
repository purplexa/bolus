package com.thrnio.bolus.core;

import java.util.Map;

public interface HookDispatcherFactory {
  String dispatcherConfigName();
  HookDispatcherFactory configure(Map<String, Object> config);
  HookDispatcher build();
}
