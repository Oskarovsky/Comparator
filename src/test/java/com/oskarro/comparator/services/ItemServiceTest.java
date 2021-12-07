package com.oskarro.comparator.services;

import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.repository.ItemRepository;
import com.oskarro.comparator.service.ItemService;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    void shouldFindItemByPrice() {
        // GIVEN
        Item item = new Item("123", "321", 1.5, false);

        // WHEN
        itemService.save(item);

        // THEN
        Iterable<Item> items = itemRepository.findByPriceEquals(1.5);
        items.forEach(System.out::println);
        assertThat(items).isNotNull();
        assertThat(items).extracting("productHash", "providerHash").contains(Tuple.tuple("123", "321"));
    }

    @Test
    void shouldFindItemsByProductId() {
        // GIVEN
        Item item = new Item("xxx", "567", 99.99, true);

        // WHEN
        itemRepository.save(item);

        // THEN
        Iterable<Item> items = itemRepository.findAllByProductHashEquals("xxx");
        System.out.println(items);
        assertThat(items).isNotNull();
    }


}
