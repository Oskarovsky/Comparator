package com.oskarro.comparator.services;

import com.oskarro.comparator.model.ComparisonOperator;
import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.model.ProductType;
import com.oskarro.comparator.repository.ItemRepository;
import com.oskarro.comparator.service.ItemService;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void shouldFindItemByPrice() {
        // GIVEN
        Item item = new Item("123", "321", 1.22, false);

        // WHEN
        itemService.save(item);

        // THEN
        Iterable<Item> items = itemService.getProductsByPriceComparison("1.0", ComparisonOperator.EQ);
        items.forEach(System.out::println);
//        assertThat(items).isNotEmpty();
//        assertThat(items).extracting("productHash", "providerHash").contains(Tuple.tuple("123", "321"));
    }

    @Test
    void shouldFindItemsByProductId() {
        // GIVEN
        Item item = new Item("xxx", "567", 99.99, true);

        // WHEN
        itemService.save(item);

        // THEN
        Iterable<Item> items = itemService.getProductsByPriceComparison("40.00", ComparisonOperator.GT);
        System.out.println(items);
        assertThat(items).isNotNull();
    }

    @Test
    void shouldFindProductBasedOnPriceComparison() {
        // GIVEN
        Item item1 = new Item(UUID.randomUUID().toString(), "providerHashTest", 20.00, true);
        Item item2 = new Item(UUID.randomUUID().toString(), "providerHashTest", 35.00, true);
        Item item3 = new Item(UUID.randomUUID().toString(), "providerHashTest", 11.00, true);
        Item item4 = new Item(UUID.randomUUID().toString(), "providerHashTest", 100.0, true);
        Item item5 = new Item(UUID.randomUUID().toString(), "providerHashTest", 2.99, true);


        // WHEN
        List<Item> itemList = Arrays.asList(item1, item2, item3, item4);
        itemService.saveAll(itemList);

        // THEN
    }


}
