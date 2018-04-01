package com.mygroupid.service.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;

import javax.inject.Inject;
import javax.inject.Named;

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
}
