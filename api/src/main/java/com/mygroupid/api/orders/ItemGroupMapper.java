package com.mygroupid.api.orders;

import com.mygroupid.api.items.ItemMapper;
import com.mygroupid.domain.orders.ItemGroup;

import javax.inject.Inject;
import javax.inject.Named;

import static com.mygroupid.domain.orders.ItemGroup.ItemGroupBuilder.itemGroup;
import static java.lang.String.valueOf;

@Named
public class ItemGroupMapper {

    @Inject
    private ItemMapper itemMapper;

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return ItemGroupDto.itemGroupDto()
                .withId(itemGroup.getId().toString())
                .withItemDto(itemMapper.toDto(itemGroup.getItem()))
                .withAmount(valueOf(itemGroup.getAmount()))
                .withShippingDate(itemGroup.getShippingDate().toString());
    }

    public ItemGroup toDomain(ItemGroupDto itemGroupDto) {
        return itemGroup()
                .withItem(itemMapper.toDomain(itemGroupDto.getItemDto()))
                .withAmount(Integer.parseInt(itemGroupDto.getAmount()))
                .build();
    }

}
