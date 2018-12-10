package org.sajt.service.commandprocessor.factory.impl;

import org.sajt.service.commandprocessor.CommandProcessor;
import org.sajt.service.commandprocessor.factory.NameAwareCommandProcessorFactory;
import org.sajt.service.commandprocessor.factory.CommandProcessorFactory;
import org.sajt.service.commandprocessor.factory.configuration.DefaultCommandProcessorConfig;
import org.sajt.service.commandprocessor.factory.exception.CommandNotFoundForNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CombinedNameAwareCommandProcessorFactory extends AbstractCommandProcessorFactory {

    Map<String, NameAwareCommandProcessorFactory> baseFactoryMap;

    @Autowired
    public CombinedNameAwareCommandProcessorFactory(List<NameAwareCommandProcessorFactory> baseFactories, DefaultCommandProcessorConfig defaultCommandProcessorConfig) {
        super(defaultCommandProcessorConfig);
        this.baseFactoryMap = new HashMap<>();
        baseFactories.forEach(factory -> baseFactoryMap.put(factory.getProcessableCommandName(), factory));
    }

    @Override
    public CommandProcessor createCommandProcessor(String name) throws CommandNotFoundForNameException {
        NameAwareCommandProcessorFactory factory = Optional.ofNullable(baseFactoryMap.get(name))
                .orElseThrow(() -> new CommandNotFoundForNameException(name));
        return factory.createCommandProcessor();
    }
}
