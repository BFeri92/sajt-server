package org.sajt.service.commandprocessor.factory;

import org.sajt.service.commandprocessor.CommandProcessor;
import org.sajt.service.commandprocessor.factory.exception.CommandNotFoundForNameException;

public interface CommandProcessorFactory {
    CommandProcessor createDefaultCommandProcessor();
    CommandProcessor createCommandProcessor(String name) throws CommandNotFoundForNameException;
}
