package org.sajt.api.world;

import org.sajt.api.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Spaceship extends WorldObject{

    private String name;
    private List<Item> items;
    private Vector velocity;
    private Player owner;

    public Spaceship() {
    }

    public Spaceship(Vector position, String name, Vector velocity, Player owner) {
        super(position);
        this.items = new ArrayList<>();
        this.name = name;
        this.velocity = velocity;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
}
