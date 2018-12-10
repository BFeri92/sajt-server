package org.sajt.service.commandprocessor;

import org.sajt.api.world.World;
import org.sajt.service.command.Command;

public class NoOpCommandProcessor extends AbstractCommandProcessor {

    public static final String COMMAND_NAME = "no-op-command-processor";

    @Override
    public void process(World world, Command command) {

    }
}
