package com.mygroupid.service.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;
import com.mygroupid.domain.items.UrgencyIndicator;
import com.mygroupid.service.orders.OrderService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ItemService {

    @Inject
    private ItemDatabase itemDatabase;

    @Inject
    private OrderService orderService;

    public Item createItem(Item item) {
        setUrgencyIndicatorForItem(item);
        return itemDatabase.createItem(item);
    }

    public List<Item> getItems() {
        return itemDatabase.getItems();
    }

    public Item getItem(String id) {
        return itemDatabase.getItem(id);
    }

    public Item updateItem(String id, Item item) {
        return setUrgencyIndicatorForItem(itemDatabase.updateItem(id, item));
    }

    private Item setUrgencyIndicatorForItem(Item item) {
        if ((Integer.parseInt(item.getAmountInStock()) < 5 && orderService.wasOrderedInLast7Days(item.getId()))
                || (Integer.parseInt(item.getAmountInStock()) < 3)) {
            item.setUrgencyIndicator(UrgencyIndicator.STOCK_LOW);
        } else if (Integer.parseInt(item.getAmountInStock()) < 10) {
            item.setUrgencyIndicator(UrgencyIndicator.STOCK_MEDIUM);
        } else if (Integer.parseInt(item.getAmountInStock()) >= 10) {
            item.setUrgencyIndicator(UrgencyIndicator.STOCK_HIGH);
        }
        return item;
    }
}
