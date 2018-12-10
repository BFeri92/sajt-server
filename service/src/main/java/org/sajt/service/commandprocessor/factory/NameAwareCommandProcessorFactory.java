package org.sajt.service.commandprocessor.factory;

import org.sajt.service.commandprocessor.CommandProcessor;

public interface NameAwareCommandProcessorFactory {
    String getProcessableCommandName();
    CommandProcessor createCommandProcessor();
}
