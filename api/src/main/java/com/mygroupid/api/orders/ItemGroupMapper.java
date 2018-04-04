package com.mygroupid.api.orders;

import com.mygroupid.api.items.ItemMapper;
import com.mygroupid.domain.orders.ItemGroup;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.mygroupid.api.orders.ItemGroupDto.itemGroupDto;
import static com.mygroupid.domain.orders.ItemGroup.ItemGroupBuilder.itemGroup;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

@Named
public class ItemGroupMapper {

    @Inject
    private ItemMapper itemMapper;

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return itemGroupDto()
                .withId(itemGroup.getId().toString())
                .withItemDto(itemMapper.toDto(itemGroup.getItem()))
                .withAmount(valueOf(itemGroup.getAmount()))
                .withShippingDate(itemGroup.getShippingDate().toString());
    }

    public ItemGroupDto[] toDto(List<ItemGroup> itemGroups) {
        return itemGroups.stream()
                .map(this::toDto)
                .collect(toList())
                .toArray(new ItemGroupDto[0]);
    }

    public ItemGroup toDomain(ItemGroupDto itemGroupDto) {
        return itemGroup()
                .withItem(itemMapper.toDomain(itemGroupDto.getItemDto()))
                .withAmount(Integer.parseInt(itemGroupDto.getAmount()))
                .build();
    }

    public List<ItemGroup> toDomain(ItemGroupDto[] itemGroupDtos) {
        return Arrays.stream(itemGroupDtos)
                .map(this::toDomain)
                .collect(toList());
    }

}
