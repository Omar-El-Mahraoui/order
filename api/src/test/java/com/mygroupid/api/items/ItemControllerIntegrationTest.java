package com.mygroupid.api.items;

import com.mygroupid.api.customers.CustomerControllerIntegrationTest;
import com.mygroupid.service.items.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;
// copied and adapted code from funiversity switchfully

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemControllerIntegrationTest.ItemControllerIntegrationTestRunner.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @SpringBootApplication(scanBasePackages = {"com.mygroupid"})
    public static class ItemControllerIntegrationTestRunner {

        public static void main(String[] args) {
            run(ItemControllerIntegrationTestRunner.class, args);
        }
    }

    @LocalServerPort
    private int port;

    @Inject
    private ItemService itemService;
    @Inject
    private ItemController itemController;

    @Before
    public void clearDatabase() {
        itemService.clearItemDatabase();
    }

    @Test
    public void createItem_givenAnEmptyDatabaseAndAnItemDto_thenAddItemToItemDatabaseAndReturnThisItemDto(){
        // given
        ItemDto itemDtoGiven = ItemDto.itemDto()
                .withName("Pen")
                .withDescription("Blue pen")
                .withPrice("1.50")
                .withAmountInStock("10");

        //when
        ItemDto ItemDtoReturned = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "items")
                        , itemDtoGiven
                        , ItemDto.class);

        //then
        assertThat(itemService.getItems()).hasSize(1);
        assertThat(ItemDtoReturned.getId()).isNotNull();
        assertThat(itemService.getItems().get(0).getName()).isEqualTo(itemDtoGiven.getName());
        assertThat(itemService.getItems().get(0).getDescription()).isEqualTo(itemDtoGiven.getDescription());
        assertThat(itemService.getItems().get(0).getPrice()).isEqualTo(new BigDecimal("1.50"));
        assertThat(itemService.getItems().get(0).getAmountInStock()).isEqualTo(10);
    }

}