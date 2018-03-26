package com.mygroupid.api.orders;

import com.mygroupid.domain.orders.ItemGroup;

import javax.inject.Named;

@Named
public class ItemGroupMapper {

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        ItemGroupDto itemGroupDto = new ItemGroupDto();
        itemGroupDto.setItemId(itemGroup.getItemId());
        itemGroupDto.setAmount(itemGroup.getAmount());
        itemGroupDto.setShippingDate(itemGroup.getShippingDate());
        return itemGroupDto;
    }

    public ItemGroup toDomain(ItemGroupDto itemGroupDto) {
        ItemGroup itemGroup = new ItemGroup();
        itemGroup.setItemId(itemGroupDto.getItemId());
        itemGroup.setAmount(itemGroupDto.getAmount());
        itemGroup.setShippingDate(itemGroupDto.getShippingDate());
        return itemGroup;
    }

}
