package com.oskarro.comparator;

import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.model.ProductType;
import com.oskarro.comparator.repository.ItemRepository;
import com.oskarro.comparator.repository.ProductRepository;
import com.oskarro.comparator.repository.ProviderRepository;
import com.oskarro.comparator.service.ProductService;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ComparatorApplicationTests {

    @Autowired
    ProviderRepository providerRepository;


    @BeforeEach
    public void init() {
        itemRepository.deleteAll();
        providerRepository.deleteAll();
    }


}
