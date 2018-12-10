package org.sajt.service.impl;

import org.sajt.api.world.World;
import org.sajt.service.WorldHandler;
import org.sajt.service.WorldHandlerFactory;
import org.sajt.service.commandprocessor.CommandProcessor;
import org.sajt.service.commandprocessor.factory.CommandProcessorFactory;
import org.sajt.service.util.ChainBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultWorldHandlerFactoryImpl implements WorldHandlerFactory {

    private CommandProcessorFactory commandProcessorFactory;

    @Autowired
    public DefaultWorldHandlerFactoryImpl(CommandProcessorFactory commandProcessorFactory) {
        this.commandProcessorFactory = commandProcessorFactory;
    }

    @Override
    public WorldHandler createWorldHandler(World world) {
        CommandProcessor commandProcessorChain = createCommandProcessorChain(world.getCommandProcessorIds());
        return new DefaultWorldHandlerImpl(world, commandProcessorChain);
    }

    private CommandProcessor createCommandProcessorChain(List<String> commandProcessorNames) {
        ChainBuilder<CommandProcessor> chainBuilder = new ChainBuilder<>();
        CommandProcessor finalCommandProcesor = commandProcessorFactory.createDefaultCommandProcessor();
        commandProcessorNames.forEach(processor -> chainBuilder.withNext(commandProcessorFactory.createCommandProcessor(processor)));
        return chainBuilder.build()
                .map(endOfChain -> endOfChain.setNextChainItem(finalCommandProcesor))
                .orElse(finalCommandProcesor);
    }
}
