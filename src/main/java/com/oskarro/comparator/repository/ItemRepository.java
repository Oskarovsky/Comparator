package com.oskarro.comparator.repository;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ItemRepository extends AbstractBaseRepository<Item, String> {

    Iterable<Item> findByPricePromotion(boolean isPromotion);

    Iterable<Item> findByPriceEquals(String price);

    Iterable<Item> findAllByProductHashEquals(String productHash);
    Iterable<Item> findAllByProviderHashEquals(String providerHash);

    Item findFirstByPrice(Double price);
}
