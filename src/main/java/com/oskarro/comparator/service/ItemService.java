package com.oskarro.comparator.service;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.common.AbstractBaseRepositoryBean;
import com.oskarro.comparator.common.JedisCommon;
import com.oskarro.comparator.exception.ResourceNotFoundException;
import com.oskarro.comparator.model.ComparisonOperator;
import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
@Transactional
public class ItemService extends AbstractBaseRepositoryBean<Item, String> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private JedisCommon jedisCommon;

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

    public Iterable<Item> getByPrice(final String price) {
        return itemRepository.findByPriceEquals(price);
    }

    public Iterable<Item> getAllByProductId(final String productId) {
        return itemRepository.findAllByProductHashEquals(productId);
    }

    public Iterable<Item> getProductsByPriceComparison(final String price, final ComparisonOperator operator) {
        switch (operator) {
            case EQ:
                return itemRepository.findByPriceEquals(price);
            default:
                throw new ResourceNotFoundException(ComparisonOperator.class.toString(), "operator mark", operator.toString());
        }
    }

    public long count() {
        return itemRepository.count();
    }
}
