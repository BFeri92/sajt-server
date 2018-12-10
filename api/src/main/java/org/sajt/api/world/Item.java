package org.sajt.api.world;

import org.sajt.api.util.ItemStateChange;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private int value;
    private List<ItemStateChange> itemHistory;

    public Item() {
    }

    public Item(String name, int value) {
        this.itemHistory = new ArrayList<>();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public List<ItemStateChange> getItemHistory() {
        return itemHistory;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addItemHistoryEntry(ItemStateChange stateChange) {
        itemHistory.add(stateChange);
    }
}
