package com.mygroupid.api.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.service.items.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    @Inject
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    //public List<Item>

    @GetMapping(path = "/{id}")
    public Item getItem(@PathVariable String id) {
        return itemService.getItem(id);
    }

    @PutMapping(path = "/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

}
