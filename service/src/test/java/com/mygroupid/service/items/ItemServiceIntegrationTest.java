package com.mygroupid.service.items;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.math.BigDecimal;

import static com.mygroupid.domain.items.Item.ItemBuilder.item;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemServiceIntegrationTest.ItemServiceIntegrationTestRunner.class)
public class ItemServiceIntegrationTest {

    @Inject
    private ItemDatabase itemDatabase;

    @Inject
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

        //when
        Item actualResult = itemService.createItem(item);

        //then
        assertThat(itemDatabase.getItems()).containsExactly(item);
        assertThat(actualResult).isEqualTo(item);
    }

    @SpringBootApplication(scanBasePackages = {"com.mygroupid"})
    public static class ItemServiceIntegrationTestRunner {

        public static void main(String[] args) {
            run(ItemServiceIntegrationTestRunner.class, args);
        }
    }

}
