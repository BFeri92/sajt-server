package org.sajt.service;

import org.sajt.api.world.World;

public interface WorldHandlerFactory {
    WorldHandler createWorldHandler(World world);
}
