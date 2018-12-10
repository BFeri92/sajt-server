package org.sajt.service.impl;

import org.sajt.api.world.World;
import org.sajt.service.WorldHandler;
import org.sajt.service.command.Command;
import org.sajt.service.commandprocessor.CommandProcessor;

import java.util.LinkedList;
import java.util.Queue;

public class DefaultWorldHandlerImpl implements WorldHandler {

    private World world;
    private CommandProcessor commandProcessorChain;
    private Queue<Command> commandQueue;

    public DefaultWorldHandlerImpl(World world, CommandProcessor commandProcessorChain) {
        this.world = world;
        this.commandProcessorChain = commandProcessorChain;
        this.commandQueue = new LinkedList<>();
    }

    @Override
    public void postCommand(Command command) {
        this.commandQueue.add(command);
    }

    @Override
    public void tick() {
        commandQueue.forEach(command -> commandProcessorChain.process(world, command));
    }

    @Override
    public World getWorld() {
        return world;
    }
}
