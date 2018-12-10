package org.sajt.service;

import org.sajt.api.world.World;
import org.sajt.service.command.Command;

public interface WorldHandler {
    void postCommand(Command command);
    void tick();
    World getWorld();
}
