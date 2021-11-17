package com.oskarro.comparator.service;

import com.oskarro.comparator.common.AbstractBaseServiceBean;
import com.oskarro.comparator.model.Provider;
import com.oskarro.comparator.common.AbstractBaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProviderService extends AbstractBaseServiceBean<Provider, String> {

    public ProviderService(AbstractBaseRepository<Provider, String> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}
