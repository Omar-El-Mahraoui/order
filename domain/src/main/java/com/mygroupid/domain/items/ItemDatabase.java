package com.mygroupid.domain.items;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Named
public class ItemDatabase {

    private List<Item> items;

    public ItemDatabase() {
        items = new ArrayList<>();
    }

    public Item createItem(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> getItems() {
        return unmodifiableList(items);
    }

    public void clearDatabase() {
        items.clear();
    }

}
