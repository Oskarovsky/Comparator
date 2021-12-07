package com.oskarro.comparator.services;

import com.oskarro.comparator.model.Measure;
import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.model.ProductType;
import com.oskarro.comparator.service.ProductService;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @BeforeEach
    public void init() {
        productService.deleteAll();
    }

    @Test
    void shouldSaveProduct() {
        // GIVEN
        Product product = new Product(UUID.randomUUID().toString(), "PRODUCT CREATE", 100, Measure.G, ProductType.FOOD);

        // WHEN
        Product saved = productService.save(product);

        // THEN
        assertThat(saved).isNotNull();
        assertThat(productService.count()).isGreaterThan(0);
    }

    @Test
    void shouldGetSavedProduct() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, "PRODUCT GET", 15, Measure.G, ProductType.FOOD);

        // WHEN
        productService.save(product);
        Optional<Product> productOptional = productService.findById(id);

        // THEN
        assertThat(productOptional).isPresent();
        Product saved = productOptional.get();
        assertThat(saved).isNotNull();
        assertThat(saved.getProductType()).isEqualTo(ProductType.FOOD);
        assertThat(saved.getName()).isEqualToIgnoringCase("Product GET");
    }

    @Test
    void shouldUpdateSavedProduct() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, "PRODUCT UPDATE", 5, Measure.KG, ProductType.FOOD);

        // WHEN
        Product saved = productService.save(product);
        saved.setProductType(ProductType.ALCOHOL);
        productService.save(product);

        // THEN
        Optional<Product> productOptional = productService.findById(id);
        assertThat(productOptional).isPresent();
        Product updated = productOptional.get();
        assertThat(updated).isNotNull();
        assertThat(updated.getName()).isEqualTo("PRODUCT UPDATE");
        assertThat(updated.getProductType()).isEqualTo(ProductType.ALCOHOL);
    }

    @Test
    void shouldDeleteSavedProduct() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, "PRODUCT DELETE", 20, Measure.G, ProductType.FOOD);

        // WHEN
        productService.save(product);
        productService.deleteById(id);

        // THEN
        assertThat(productService.findById(id)).isEmpty();
    }

    @Test
    void shouldFindAllProduct() {
        // GIVEN
        Product productOne = new Product(UUID.randomUUID().toString(), "PRODUCT FIND ALL 1", 40, Measure.G, ProductType.FOOD);
        Product productTwo = new Product(UUID.randomUUID().toString(), "PRODUCT FIND ALL 2", 50, Measure.G, ProductType.OTHER);

        // WHEN
        productService.save(productOne);
        productService.save(productTwo);
        Spliterator<Product> productSpliterator = productService.findAll().spliterator();
        List<Product> products = StreamSupport.stream(productSpliterator, false).collect(Collectors.toList());

        // THEN
        assertThat(products.size()).isGreaterThan(1);
        assertThat(products).extracting("name", "productType").contains(Tuple.tuple("PRODUCT FIND ALL 1", ProductType.FOOD));
        assertThat(products).extracting("name", "productType").contains(Tuple.tuple("PRODUCT FIND ALL 2", ProductType.OTHER));
    }

}
