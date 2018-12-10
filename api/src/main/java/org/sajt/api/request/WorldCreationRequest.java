package org.sajt.api.request;

import org.sajt.api.world.Planet;
import org.sajt.api.world.Player;

import java.util.List;

public class WorldCreationRequest {

    private String name;
    private long height;
    private long width;
    private List<String> commandProcessorIds;

    private List<Planet> planets;
    private List<Player> players;
    private List<SpaceshipInitialStateDescriptor> spaceships;

    public WorldCreationRequest() {
    }

    public WorldCreationRequest(String name,
                                long height,
                                long width,
                                List<String> commandProcessorIds,
                                List<Planet> planets,
                                List<Player> players,
                                List<SpaceshipInitialStateDescriptor> spaceships) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.commandProcessorIds = commandProcessorIds;
        this.planets = planets;
        this.players = players;
        this.spaceships = spaceships;
    }

    public String getName() {
        return name;
    }

    public long getHeight() {
        return height;
    }

    public long getWidth() {
        return width;
    }

    public List<String> getCommandProcessorIds() {
        return commandProcessorIds;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<SpaceshipInitialStateDescriptor> getSpaceships() {
        return spaceships;
    }

}
