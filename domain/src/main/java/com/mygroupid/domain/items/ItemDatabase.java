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

    public Item getItem(String id) {
        return items.stream()
                .filter(i->i.getId().equals(id))
                .findFirst()
                .get();
    }

    public Item updateItem(String id, Item item) {
        int indexOfItemToUpdate = 0;
        for (int index=0; index<items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.get(index).setName(item.getName());
                items.get(index).setDescription(item.getDescription());
                items.get(index).setPrice(item.getPrice());
                items.get(index).setAmountInStock(item.getAmountInStock());
                indexOfItemToUpdate = index;
            }
        }
        return items.get(indexOfItemToUpdate);
    }

    public void clearDatabase() {
        items.clear();
    }
}
