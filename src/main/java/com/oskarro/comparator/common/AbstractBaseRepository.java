package com.oskarro.comparator.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Serializable>
        extends CrudRepository<T, ID> {

}