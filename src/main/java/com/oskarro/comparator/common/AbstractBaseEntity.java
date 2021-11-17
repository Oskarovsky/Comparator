package com.oskarro.comparator.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AbstractBaseEntity implements Serializable {

    @Id
    private String hash;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AbstractBaseEntity() {
        this.hash = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
