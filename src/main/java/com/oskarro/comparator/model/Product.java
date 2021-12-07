package com.oskarro.comparator.model;

import com.oskarro.comparator.common.AbstractBaseEntity;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@RedisHash("Product")
@NoArgsConstructor
public class Product extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer size;
    private Measure measure;
    private ProductType productType;

    public Product(String name, Integer size, Measure measure, ProductType productType) {
        super.setHash(UUID.randomUUID().toString());
        this.name = name;
        this.size = size;
        this.measure = measure;
        this.productType = productType;
    }

    public Product(String id, String name, Integer size, Measure measure, ProductType productType) {
        super.setHash(id);
        this.name = name;
        this.size = size;
        this.measure = measure;
        this.productType = productType;
    }
}

