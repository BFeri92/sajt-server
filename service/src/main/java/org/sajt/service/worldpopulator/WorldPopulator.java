package org.sajt.service.worldpopulator;

import org.sajt.api.world.World;
import org.sajt.api.request.WorldCreationRequest;
import org.sajt.service.util.ChainItem;

public interface WorldPopulator extends ChainItem<WorldPopulator> {
    void populate(WorldCreationRequest request, World world);
}
