package org.sajt.service.worldpopulator.impl;

import org.sajt.api.request.WorldCreationRequest;
import org.sajt.api.world.World;

public class PlanetWorldPopulator extends AbstractWorldPopulator {

    @Override
    public void populate(WorldCreationRequest request, World world) {
        request.getPlanets().forEach(world::addPlanet);
    }
}
