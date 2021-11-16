package com.oskarro.comparator.gateway;

import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductGateway {

    ProductRepository productRepository;

    public ProductGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Product>> getAll() {
        return new ResponseEntity<Iterable<Product>>(productRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable final String productId) throws Exception {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(Exception::new);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable final String productId) {
        productRepository.deleteById(productId);
    }


}
