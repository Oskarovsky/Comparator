package com.oskarro.comparator.repository;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends AbstractBaseRepository<Item, String> {
}
