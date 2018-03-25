package com.mygroupid.domain.items;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ItemRepository {

    @Inject
    private ItemDatabase itemDatabase;

    public Item createItem(Item item) {
        return itemDatabase.createItem(item);
    }

    public List<Item> getItems() {
        return itemDatabase.getItems();
    }

    public Item getItem(String id) {
        return itemDatabase.getItem(id);
    }

    public Item updateItem(String id, Item item) {
        return itemDatabase.updateItem(id, item);
    }
}
