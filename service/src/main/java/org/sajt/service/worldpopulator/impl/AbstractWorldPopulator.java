package org.sajt.service.worldpopulator.impl;

import org.sajt.service.worldpopulator.WorldPopulator;

import java.util.Optional;

public abstract class AbstractWorldPopulator implements WorldPopulator {

    private WorldPopulator nextChainItem;

    @Override
    public WorldPopulator setNextChainItem(WorldPopulator item) {
        nextChainItem = item;
        return item;
    }

    @Override
    public Optional<WorldPopulator> getNextChainItem() {
        return Optional.ofNullable(nextChainItem);
    }
}
