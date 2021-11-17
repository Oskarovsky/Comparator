package com.oskarro.comparator.repository;

import com.oskarro.comparator.common.AbstractBaseRepository;
import com.oskarro.comparator.model.Provider;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends AbstractBaseRepository<Provider, String> {
}
