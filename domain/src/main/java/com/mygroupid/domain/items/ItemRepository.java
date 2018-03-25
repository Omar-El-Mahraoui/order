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
}
