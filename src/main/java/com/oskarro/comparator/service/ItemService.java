package com.oskarro.comparator.service;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.common.AbstractBaseServiceBean;
import com.oskarro.comparator.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractBaseServiceBean<Item, String> {

    public ItemService(AbstractBaseRepository<Item, String> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}
