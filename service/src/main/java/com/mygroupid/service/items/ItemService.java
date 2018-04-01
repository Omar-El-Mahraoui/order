package com.mygroupid.service.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ItemService {

    @Inject
    private ItemDatabase itemDatabase;

    public Item createItem(Item item) {
        return itemDatabase.createItem(item);
    }

    public void clearItemDatabase() {
        itemDatabase.clearDatabase();
    }

    public List<Item> getItems() {
        return itemDatabase.getItems();
    }
}
