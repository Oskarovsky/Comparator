package com.oskarro.comparator.common;

import java.io.Serializable;
import java.util.Optional;

public interface AbstractBaseService<T extends AbstractBaseEntity, ID extends Serializable>{

    Iterable<T> findAll();
    Optional<T> findById(ID entityId);
    Iterable<T> findAllById(Iterable<ID> ids);

    boolean existsById(ID id);

    T save(T entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    T update(T entity);
    T updateById(T entity, ID entityId);

    void deleteAll();
    void deleteAllById(Iterable<? extends ID> ids);
    void delete(T entity);
    void deleteById(ID entityId);

    long count();

}