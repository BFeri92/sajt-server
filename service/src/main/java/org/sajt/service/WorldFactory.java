package org.sajt.service;

import org.sajt.api.request.WorldCreationRequest;
import org.sajt.api.world.World;

public interface WorldFactory {
    World createWorld(WorldCreationRequest request);
}
