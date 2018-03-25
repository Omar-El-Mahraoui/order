/*
package com.mygroupid.api.orders;

import com.mygroupid.api.items.ItemMapper;
import com.mygroupid.domain.items.ItemGroup;

import javax.inject.Inject;
import javax.inject.Named;

import static java.lang.String.valueOf;

@Named
public class ItemGroupMapper {

    @Inject
    private ItemMapper itemMapper;

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return new ItemGroupDto(
                itemMapper.toDto(itemGroup.getItem()),
                valueOf(itemGroup.getAmountOfItems()));
    }

    public ItemGroup toDomain(ItemGroupDto itemGroupDto) {
        return ItemGroup.ItemGroupBuilder.itemGroup()
                .withItem(itemMapper.toDomain(itemGroupDto.getItem()))
                .withAmountOfItems(Integer.parseInt(itemGroupDto.getAmountOfItems()))
                .build();
    }

}
*/
