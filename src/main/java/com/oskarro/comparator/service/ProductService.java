package com.oskarro.comparator.service;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.common.AbstractBaseServiceBean;
import com.oskarro.comparator.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractBaseServiceBean<Product, String> {

    public ProductService(AbstractBaseRepository<Product, String> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}
