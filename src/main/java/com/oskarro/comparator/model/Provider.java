package com.oskarro.comparator.model;


import com.oskarro.comparator.common.AbstractBaseEntity;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@RedisHash("Provider")
@NoArgsConstructor
@AllArgsConstructor
public class Provider extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private String city;
}
