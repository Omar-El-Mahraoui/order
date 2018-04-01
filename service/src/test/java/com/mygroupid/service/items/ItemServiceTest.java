package com.mygroupid.service.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static com.mygroupid.domain.items.Item.ItemBuilder.item;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemDatabase itemDatabase;

    @InjectMocks
    private ItemService itemService;

    @Before
    public void clearItemDatabase() {
        itemDatabase.clearDatabase();
    }

    @Test
    public void createItem_givenAnItem_thenAddItToItemDatabaseAndReturnTheItem() {
        // given
        Item item = item()
                .withName("Pen")
                .withDescription("A blue pen to wriet with")
                .withPrice(new BigDecimal("1.00"))
                .withAmountInStock(5)
                .build();
        Mockito.when(itemDatabase.createItem(item)).thenReturn(item);

        //when
        Item actualResult = itemService.createItem(item);

        //then
        assertThat(actualResult).isEqualTo(item);
    }

}