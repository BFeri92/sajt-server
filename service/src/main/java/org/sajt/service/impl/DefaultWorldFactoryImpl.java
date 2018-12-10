package org.sajt.service.impl;

import org.sajt.api.request.WorldCreationRequest;
import org.sajt.api.world.World;
import org.sajt.service.WorldFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultWorldFactoryImpl implements WorldFactory {
    @Override
    public World createWorld(WorldCreationRequest request) {
        return new World(request.getName(), request.getHeight(), request.getWidth(), request.getCommandProcessorIds());
    }
}
