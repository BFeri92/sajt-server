package org.sajt.service.worldclock.impl;

import org.sajt.service.WorldContainerManager;
import org.sajt.service.worldclock.WorldClock;
import org.sajt.service.worldclock.configuration.WorldClockProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class DefaultWorldClockImpl implements WorldClock {

    private ScheduledExecutorService executorService;
    private WorldClockProperties properties;
    private WorldContainerManager worldContainerManager;

    public DefaultWorldClockImpl(WorldClockProperties properties, WorldContainerManager worldContainerManager) {
        this.properties = properties;
        this.worldContainerManager = worldContainerManager;
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    @PostConstruct
    public void startUp() {
        this.start();
    }

    @PreDestroy
    public void tearDown() {
        this.stop();
    }


    @Override
    public void start() {
        executorService.scheduleAtFixedRate(() -> worldContainerManager.stepWorlds(), properties.getInitialDelay(), properties.getPeriod(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void stop() {
        executorService.shutdown();
    }
}
