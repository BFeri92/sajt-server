package org.sajt.api.util;

import org.sajt.api.world.WorldObject;

public class ItemStateChange {
    private final WorldObject place;
    private final ItemStateChangeType type;

    public ItemStateChange(WorldObject place, ItemStateChangeType type) {
        this.place = place;
        this.type = type;
    }

    public WorldObject getPlace() {
        return place;
    }

    public ItemStateChangeType getType() {
        return type;
    }
}
