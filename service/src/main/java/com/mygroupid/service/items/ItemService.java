package com.mygroupid.service.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ItemService {

    @Inject
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.createItem(item);
    }

    public List<Item> getItems() {
        return itemRepository.getItems();
    }
}