package com.mygroupid.api.orders;

import com.mygroupid.api.items.ItemMapper;
import com.mygroupid.domain.items.ItemGroup;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static com.mygroupid.domain.items.ItemGroup.ItemGroupBuilder.itemGroup;
import static java.lang.String.valueOf;

@Named
public class ItemGroupMapper {

    @Inject
    private ItemMapper itemMapper;

    public List<ItemGroupDto> toDto(List<ItemGroup> itemGroups) {
        List<ItemGroupDto> itemGroupDtoList = new ArrayList<>();
        for(int index=0; index<itemGroups.size(); index++) {
            itemGroupDtoList.add(new ItemGroupDto(
                    itemMapper.toDto(itemGroups.get(index).getItem()),
                    valueOf(itemGroups.get(index).getAmountOfItems()))
            );
        }
        return itemGroupDtoList;
    }

    public List<ItemGroup> toDomain(List<ItemGroupDto> itemGroupDtos) {
        List<ItemGroup> itemGroupList = new ArrayList<>();
        for(int index=0; index<itemGroupDtos.size(); index++) {
            itemGroupList.add(
                    itemGroup()
                    .withItem(itemMapper.toDomain(itemGroupDtos.get(index).getItem()))
                    .withAmountOfItems(Integer.parseInt(itemGroupDtos.get(index).getAmountOfItems()))
                    .build()
            );
        }
        return itemGroupList;
    }

}
