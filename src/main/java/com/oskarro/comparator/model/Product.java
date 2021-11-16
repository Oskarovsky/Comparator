package com.oskarro.comparator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@RedisHash("Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private String id;
    private String name;
    private ProductType productType;
}

