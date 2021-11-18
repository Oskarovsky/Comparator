package com.oskarro.comparator.service;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.common.AbstractBaseRepositoryBean;
import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService extends AbstractBaseRepositoryBean<Item, String> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        super(itemRepository);
    }

    public ItemService(AbstractBaseRepository<Item, String> abstractBaseRepository) {
        super(abstractBaseRepository);
    }

    public Iterable<Item> findByPricePromotion(final boolean isPromotion) {
        return itemRepository.findByPricePromotion(isPromotion);
    }

    public Iterable<Item> findByPrice(Double price) {
        return itemRepository.findByPriceEquals(price);
    }

    public Iterable<Item> findAllByProductId(String productId) {
        return itemRepository.findAllByProductHashEquals(productId);
    }

    public long count() {
        return itemRepository.count();
    }
}
