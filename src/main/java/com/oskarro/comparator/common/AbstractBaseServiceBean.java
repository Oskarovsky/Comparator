package com.oskarro.comparator.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Service
@Transactional
public abstract class AbstractBaseServiceBean<T extends AbstractBaseEntity, ID extends Serializable>
        implements AbstractBaseService<T, ID> {

    private final AbstractBaseRepository<T, ID> abstractBaseRepository;

    @Autowired
    public AbstractBaseServiceBean(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    @Override
    public Iterable<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return abstractBaseRepository.findById(entityId);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        return abstractBaseRepository.findAllById(ids);
    }

    @Override
    public boolean existsById(ID id) {
        return abstractBaseRepository.existsById(id);
    }

    @Override
    public T save(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return abstractBaseRepository.saveAll(entities);
    }

    @Override
    public T update(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if(optional.isPresent()){
            return (T) abstractBaseRepository.save(entity);
        }else{
            return null;
        }
    }

    @Override
    public void deleteAll() {
        abstractBaseRepository.deleteAll();
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {
        abstractBaseRepository.deleteAllById(ids);
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }

    @Override
    public long count() {
        return abstractBaseRepository.count();
    }

}