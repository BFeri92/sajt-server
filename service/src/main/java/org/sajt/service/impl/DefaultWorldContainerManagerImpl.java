package org.sajt.service.impl;

import org.sajt.api.world.World;
import org.sajt.service.WorldContainerManager;
import org.sajt.service.WorldFactory;
import org.sajt.service.WorldHandler;
import org.sajt.service.WorldHandlerFactory;
import org.sajt.service.commandprocessor.CommandProcessor;
import org.sajt.api.request.WorldCreationRequest;
import org.sajt.service.worldpopulator.WorldPopulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DefaultWorldContainerManagerImpl implements WorldContainerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultWorldContainerManagerImpl.class);

    private WorldHandlerFactory worldHandlerFactory;
    private WorldFactory worldFactory;
    private Map<String, WorldHandler> worlds;
    private WorldPopulator populatorChain;

    @Autowired
    public DefaultWorldContainerManagerImpl(WorldHandlerFactory worldHandlerFactory, WorldFactory worldFactory, WorldPopulator worldPopulatorChain) {
        this.worldHandlerFactory = worldHandlerFactory;
        this.worldFactory = worldFactory;
        this.worlds = new ConcurrentHashMap<>();
        this.populatorChain = worldPopulatorChain;
    }

    @Override
    public void createWorld(WorldCreationRequest request) {
        LOGGER.info("Creating world for request={}", request);
        World world = worldFactory.createWorld(request);
        populatorChain.populate(request, world);
        WorldHandler worldHandler = worldHandlerFactory.createWorldHandler(world);
        this.worlds.put(request.getName(), worldHandler);
        LOGGER.info("Created world with name={}", world.getName());
    }

    @Override
    public Optional<World> getWorld(String name) {
        return Optional.ofNullable(worlds.get(name))
                .map(WorldHandler::getWorld);
    }

    @Override
    public Set<String> getWorldNames() {
        return worlds.keySet();
    }

    @Override
    public void stepWorlds() {
        LOGGER.info("Starting calculation of next world states...");
        worlds.values().forEach(WorldHandler::tick);
    }
}
