package org.sajt.api.request;

import org.sajt.api.util.Vector;
import org.sajt.api.world.Item;

import java.util.List;

public class SpaceshipInitialStateDescriptor {
    private String name;
    private String owner;
    private Vector initialPosition;

    public SpaceshipInitialStateDescriptor(String name, String owner, Vector initialPosition) {
        this.name = name;
        this.owner = owner;
        this.initialPosition = initialPosition;
    }

    public SpaceshipInitialStateDescriptor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Vector getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Vector initialPosition) {
        this.initialPosition = initialPosition;
    }
}
