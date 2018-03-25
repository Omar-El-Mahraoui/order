package com.mygroupid.api.items;


import com.mygroupid.domain.items.Item;
import com.mygroupid.service.items.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    @Inject
    private ItemService itemService;
    @Inject
    private ItemMapper itemMapper;

    @PostMapping
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return itemMapper.toDto(itemService.createItem(itemMapper.toDomain(itemDto)));
    }

    @GetMapping
    public List<ItemDto> getCustomers() {
        return itemService.getItems().stream()
                .map(itemMapper::toDto)
                .collect(toList());
    }

}
