package org.sajt.api.world;

import java.util.*;
import java.util.stream.Collectors;

public class World {

    private String name;
    private long height;
    private long width;

    private Map<String, Spaceship> spaceships;
    private Map<String, Planet> planets;
    private Map<String, Player> players;
    private List<String> commandProcessorIds;
    private WorldStatus worldStatus;

    public World() {
    }

    public World(String name, long height, long width, List<String> commandProcessorIds) {
        this.commandProcessorIds = commandProcessorIds;
        this.spaceships = new HashMap<>();
        this.planets = new HashMap<>();
        this.players = new HashMap<>();
        this.name = name;
        this.height = height;
        this.width = width;
        this.worldStatus = WorldStatus.CREATED;
    }

    public WorldStatus getWorldStatus() {
        return worldStatus;
    }

    public void setWorldStatus(WorldStatus worldStatus) {
        this.worldStatus = worldStatus;
    }

    public Map<String, Spaceship> getSpaceships() {
        return Collections.unmodifiableMap(spaceships);
    }

    public Map<String, Planet> getPlanets() {
        return Collections.unmodifiableMap(planets);
    }

    public Map<String, Player> getPlayers() {
        return Collections.unmodifiableMap(players);
    }

    public void addSpaceship(Spaceship spaceship) {
        this.spaceships.put(spaceship.getName(), spaceship);
    }

    public void addPlanet(Planet planet) {
        this.planets.put(planet.getName(), planet);
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
    }

    public Optional<Spaceship> getSpaceship(String name) {
        return Optional.of(spaceships.get(name));
    }

    public Optional<Planet> getPlanet(String name) {
        return Optional.of(planets.get(name));
    }

    public Optional<Player> getPlayer(String name) {
        return Optional.of(players.get(name));
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

}
