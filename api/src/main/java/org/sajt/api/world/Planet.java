package org.sajt.api.world;

import org.sajt.api.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Planet extends WorldObject{

    private long radius;
    private String name;

    private List<Item> items;

    public Planet() {
    }

    public Planet(Vector position, long radius, String name) {
        super(position);
        this.items = new ArrayList<>();
        this.radius = radius;
        this.name = name;
    }

    public long getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
