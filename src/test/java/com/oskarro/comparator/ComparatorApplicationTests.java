package com.oskarro.comparator;

import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.model.ProductType;
import com.oskarro.comparator.repository.ProductRepository;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ComparatorApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void shouldSaveProduct() {
        // GIVEN
        Product product = new Product(UUID.randomUUID().toString(), "PRODUCT CREATE", 1.5, ProductType.FOOD);

        // WHEN
        Product saved = productRepository.save(product);

        // THEN
        assertThat(saved).isNotNull();
        assertThat(productRepository.count()).isGreaterThan(0);
    }

    @Test
    void shouldGetSavedProduct() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, "PRODUCT GET", 1.5, ProductType.FOOD);

        // WHEN
        productRepository.save(product);
        Optional<Product> productOptional = productRepository.findById(id);

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
        Product product = new Product(id, "PRODUCT UPDATE", 1.5, ProductType.FOOD);

        // WHEN
        Product saved = productRepository.save(product);
        saved.setProductType(ProductType.ALCOHOL);
        productRepository.save(product);

        // THEN
        Optional<Product> productOptional = productRepository.findById(id);
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
        Product product = new Product(id, "PRODUCT DELETE", 1.5, ProductType.FOOD);

        // WHEN
        productRepository.save(product);
        productRepository.deleteById(id);

        // THEN
        assertThat(productRepository.findById(id)).isEmpty();
    }

    @Test
    void shouldFindAllProduct() {
        // GIVEN
        Product productOne = new Product(UUID.randomUUID().toString(), "PRODUCT FIND ALL 1", 1.5, ProductType.FOOD);
        Product productTwo = new Product(UUID.randomUUID().toString(), "PRODUCT FIND ALL 2", 1.5, ProductType.OTHER);

        // WHEN
        productRepository.save(productOne);
        productRepository.save(productTwo);
        Spliterator<Product> productSpliterator = productRepository.findAll().spliterator();
        List<Product> products = StreamSupport.stream(productSpliterator, false).collect(Collectors.toList());

        // THEN
        assertThat(products.size()).isGreaterThan(1);
        assertThat(products).extracting("name", "productType").contains(Tuple.tuple("PRODUCT FIND ALL 1", ProductType.FOOD));
        assertThat(products).extracting("name", "productType").contains(Tuple.tuple("PRODUCT FIND ALL 2", ProductType.OTHER));
    }






}
