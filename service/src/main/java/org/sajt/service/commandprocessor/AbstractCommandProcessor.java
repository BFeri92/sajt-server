package org.sajt.service.commandprocessor;

import java.util.Optional;

public abstract class AbstractCommandProcessor implements CommandProcessor {

    private CommandProcessor nextCommandProcessor;

    @Override
    public CommandProcessor setNextChainItem(CommandProcessor item) {
        this.nextCommandProcessor = item;
        return item;
    }

    @Override
    public Optional<CommandProcessor> getNextChainItem() {
        return Optional.ofNullable(nextCommandProcessor);
    }
}
