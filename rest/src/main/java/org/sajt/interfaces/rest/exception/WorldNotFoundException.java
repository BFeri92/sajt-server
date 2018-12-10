package org.sajt.interfaces.rest.exception;

public class WorldNotFoundException extends Exception {
    public WorldNotFoundException(String worldName) {
        super("World with name "+worldName+" could not be found");
    }
}
