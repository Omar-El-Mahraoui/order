/*
package com.mygroupid.api.items;

import com.mygroupid.domain.items.Item;

import javax.inject.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.mygroupid.domain.items.Item.ItemBuilder.item;
import static java.lang.String.valueOf;

@Named
public class ItemMapper {

    public ItemDto toDto(Item item) {
        return new ItemDto(item.getName()
                            , item.getDescription()
                            , item.getPrice().toString()
                            , valueOf(item.getAmountInStock()));
    }

    public Item toDomain(ItemDto itemDto) {
        return item()
                .withName(itemDto.getName())
                .withDescription(itemDto.getDescription())
                .withPrice(new BigDecimal(itemDto.getPrice()).setScale(2, RoundingMode.CEILING))
                .withAmountInStock(Integer.parseInt(itemDto.getAmountInStock()))
                .build();
    }

}
*/
