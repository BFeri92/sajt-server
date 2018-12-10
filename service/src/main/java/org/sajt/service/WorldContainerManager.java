package org.sajt.service;

import org.sajt.api.request.WorldCreationRequest;
import org.sajt.api.world.World;

import java.util.Optional;
import java.util.Set;

public interface WorldContainerManager {
    void createWorld(WorldCreationRequest request);

    Optional<World> getWorld(String name);
    Set<String> getWorldNames();

    void stepWorlds();
}
