package org.sajt.service.commandprocessor;

import org.sajt.api.world.World;
import org.sajt.service.command.Command;
import org.sajt.service.util.ChainItem;

public interface CommandProcessor extends ChainItem<CommandProcessor> {
    void process(World world, Command command);
}
