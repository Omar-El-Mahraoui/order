package com.mygroupid.api.items;
//copied and adapted code from funiversity example switchfully


import com.mygroupid.service.items.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    @Inject
    private ItemService itemService;
    @Inject
    private ItemMapper itemMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return itemMapper.toDto(
                itemService.createItem(itemMapper.toDomain(itemDto)));
    }

}
