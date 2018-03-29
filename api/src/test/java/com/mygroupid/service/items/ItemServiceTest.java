package com.mygroupid.service.items;
// copied and adapted code from funiversity

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;
import com.mygroupid.domain.items.UrgencyIndicator;
import com.mygroupid.service.orders.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemDatabase itemDatabase;
    @Mock
    private OrderService orderService;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void updateItem_givenAnItemIdAndANewItem_thenChangeTheInstanceVariablesOfThisItemInTheItemDatabaseAndReturnNewItem() {
        // given
        Item oldItem = new Item();
        oldItem.setName("pen");
        oldItem.setDescription("blue pen");
        oldItem.setPrice("1.00");
        oldItem.setAmountInStock("5");

        Item newItem = new Item();
        newItem.setId(oldItem.getId());
        newItem.setName("pen updated");
        newItem.setDescription("blue pen updated");
        newItem.setPrice("1.00");
        newItem.setAmountInStock("2");

        when(itemDatabase.updateItem(oldItem.getId(), newItem)).thenReturn(newItem);

        Item expectedItem = newItem;
        expectedItem.setUrgencyIndicator(UrgencyIndicator.STOCK_LOW);

        //when
        Item actualResult = itemService.updateItem(oldItem.getId(), newItem);

        //then
        org.assertj.core.api.Assertions
                .assertThat(actualResult)
                .isEqualTo(expectedItem);
    }

}