package com.thrnio.bolus;

import com.thrnio.bolus.core.HookDispatcherList;
import com.thrnio.bolus.resources.Hooks;
import com.thrnio.bolus.resources.Root;
import com.thrnio.bolus.resources.Version;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;


public class BolusApplication extends Application<BolusConfiguration> {
  public static void main(String[] args) throws Exception {
    new BolusApplication().run(args);
  }

  @Override
  public String getName() {
    return "Bolus";
  }

  @Override
  public void initialize(Bootstrap<BolusConfiguration> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(BolusConfiguration configuration,
                  Environment environment) {
    final ExecutorService dispatcherQueue = environment.lifecycle()
        .executorService("dispatcherQueue-%d")
        .workQueue(new LinkedBlockingQueue<>())
        .build();
    final HookDispatcherList dispatchers = new HookDispatcherList(configuration.dispatchers());
    final Root root = new Root();
    final Version version = new Version();
    final Hooks hooks = new Hooks(dispatcherQueue, dispatchers);
    environment.jersey().register(root);
    environment.jersey().register(version);
    environment.jersey().register(hooks);
  }
}
