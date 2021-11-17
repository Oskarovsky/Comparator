package com.oskarro.comparator.model;

import com.oskarro.comparator.common.AbstractBaseEntity;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@RedisHash("Item")
@NoArgsConstructor
public class Item extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    private Product product;
    private Provider provider;
    private Double price;
    private boolean isPricePromotion;


    public Item(Product product, Provider provider, Double price, boolean isPricePromotion) {
        super.setId(UUID.randomUUID().toString());
        this.product = product;
        this.provider = provider;
        this.price = price;
        this.isPricePromotion = isPricePromotion;
    }

    public Item(String id, Product product, Provider provider, Double price, boolean isPricePromotion) {
        super.setId(id);
        this.product = product;
        this.provider = provider;
        this.price = price;
        this.isPricePromotion = isPricePromotion;
    }
}
