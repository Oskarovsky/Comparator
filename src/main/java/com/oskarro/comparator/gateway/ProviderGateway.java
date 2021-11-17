package com.oskarro.comparator.gateway;

import com.oskarro.comparator.model.Provider;
import com.oskarro.comparator.repository.ProviderRepository;
import com.oskarro.comparator.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/provider")
public class ProviderGateway {

    ProviderService providerService;

    public ProviderGateway(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Provider>> getAll() {
        return new ResponseEntity<>(providerService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{providerId}")
    public ResponseEntity<Provider> findById(@PathVariable final String providerId) throws Exception {
        Provider provider = providerService
                .findById(providerId)
                .orElseThrow(Exception::new);
        return new ResponseEntity<>(provider, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Provider> create(@RequestBody Provider provider) {
        if (provider.getId().isEmpty()) {
            provider.setId(UUID.randomUUID().toString());
        }
        Provider save = providerService.save(provider);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @DeleteMapping("/{providerId}")
    public void delete(@PathVariable final String providerId) {
        providerService.deleteById(providerId);
    }
}
