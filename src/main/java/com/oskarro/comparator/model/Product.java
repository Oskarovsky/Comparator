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

    public Product(String name, Double size, ProductType productType) {
        super.setHash(UUID.randomUUID().toString());
        this.name = name;
        this.size = size;
        this.productType = productType;
    }

    public Product(String id, String name, Double size, ProductType productType) {
        super.setHash(id);
        this.name = name;
        this.size = size;
        this.productType = productType;
    }

    private String name;
    private Double size;
    private ProductType productType;
}

