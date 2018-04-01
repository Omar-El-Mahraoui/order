package com.mygroupid.api.items;

import com.mygroupid.domain.items.Item;

import javax.inject.Named;

import java.math.BigDecimal;

import static com.mygroupid.api.items.ItemDto.itemDto;

@Named
public class ItemMapper {

    public ItemDto toDto(Item item) {
        return itemDto()
                .withId(item.getId().toString())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice().toString())
                .withAmountInStock(String.valueOf(item.getAmountInStock()));
    }

    public Item toDomain(ItemDto itemDto) {
        return Item.ItemBuilder.item()
                .withName(itemDto.getName())
                .withDescription(itemDto.getDescription())
                .withPrice(new BigDecimal(itemDto.getPrice()))
                .withAmountInStock(Integer.parseInt(itemDto.getAmountInStock()))
                .build();
    }

}
