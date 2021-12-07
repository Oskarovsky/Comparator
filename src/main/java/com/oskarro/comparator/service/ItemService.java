package com.oskarro.comparator.service;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.common.AbstractBaseRepositoryBean;
import com.oskarro.comparator.model.ComparisonOperator;
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

    public Iterable<Item> getByPricePromotion(final boolean isPromotion) {
        return itemRepository.findByPricePromotion(isPromotion);
    }

    public Iterable<Item> getByPrice(final Double price) {
        return itemRepository.findByPriceEquals(price);
    }

    public Iterable<Item> getAllByProductId(final String productId) {
        return itemRepository.findAllByProductHashEquals(productId);
    }

    public Iterable<Item> getProductsByPriceComparison(final Double price, final ComparisonOperator operator) {
        return null;
    }

    public long count() {
        return itemRepository.count();
    }
}
