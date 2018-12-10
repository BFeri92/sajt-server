package org.sajt.service.commandprocessor.factory.impl;

import org.sajt.service.commandprocessor.CommandProcessor;
import org.sajt.service.commandprocessor.factory.CommandProcessorFactory;
import org.sajt.service.commandprocessor.factory.configuration.DefaultCommandProcessorConfig;

public abstract class AbstractCommandProcessorFactory implements CommandProcessorFactory {

    DefaultCommandProcessorConfig defaultCommandProcessorConfig;

    public AbstractCommandProcessorFactory(DefaultCommandProcessorConfig defaultCommandProcessorConfig) {
        this.defaultCommandProcessorConfig = defaultCommandProcessorConfig;
    }

    @Override
    public CommandProcessor createDefaultCommandProcessor() {
        return this.createCommandProcessor(defaultCommandProcessorConfig.getName());
    }
}
