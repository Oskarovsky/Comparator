package com.oskarro.comparator.model;

import com.oskarro.comparator.common.AbstractBaseEntity;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Data
//@Builder
@RedisHash("Item")
@ToString
@NoArgsConstructor
public class Item extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    @Indexed
    private String productHash;
    private String providerHash;
    private boolean isPricePromotion;
    @Indexed
    private Double price;


    public Item(String productHash, String providerHash, Double price, boolean isPricePromotion) {
        super.setHash(UUID.randomUUID().toString());
        this.productHash = productHash;
        this.providerHash = providerHash;
        this.price = price;
        this.isPricePromotion = isPricePromotion;
    }

    public Item(String id, String productHash, String providerHash, Double price, boolean isPricePromotion) {
        super.setHash(id);
        this.productHash = productHash;
        this.providerHash = providerHash;
        this.price = price;
        this.isPricePromotion = isPricePromotion;
    }
}
