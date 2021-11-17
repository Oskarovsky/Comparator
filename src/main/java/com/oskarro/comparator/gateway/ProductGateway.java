package com.oskarro.comparator.gateway;

import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
public class ProductGateway {

    ProductService productService;

    public ProductGateway(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Product>> getAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable final String productId) throws Exception {
        Product product = productService
                .findById(productId)
                .orElseThrow(Exception::new);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product save = productService.save(product);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable final String productId) {
        productService.deleteById(productId);
    }


}
