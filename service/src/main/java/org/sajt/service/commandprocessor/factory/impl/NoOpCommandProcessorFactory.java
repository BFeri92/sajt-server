package org.sajt.service.commandprocessor.factory.impl;

import org.sajt.service.commandprocessor.CommandProcessor;
import org.sajt.service.commandprocessor.NoOpCommandProcessor;
import org.sajt.service.commandprocessor.factory.NameAwareCommandProcessorFactory;
import org.springframework.stereotype.Component;

@Component
public class NoOpCommandProcessorFactory implements NameAwareCommandProcessorFactory {
    @Override
    public String getProcessableCommandName() {
        return NoOpCommandProcessor.COMMAND_NAME;
    }

    @Override
    public CommandProcessor createCommandProcessor() {
        return new NoOpCommandProcessor();
    }
}
