package org.sajt.api.world;

import org.sajt.api.util.Vector;

public class WorldObject {
    private Vector position;

    public WorldObject() {
    }

    public WorldObject(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }
}
