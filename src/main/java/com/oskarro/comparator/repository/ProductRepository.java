package com.oskarro.comparator.repository;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends AbstractBaseRepository<Product, String> {


}
