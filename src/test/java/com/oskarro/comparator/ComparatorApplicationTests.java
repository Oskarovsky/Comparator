package com.oskarro.comparator;

import com.oskarro.comparator.model.Product;
import com.oskarro.comparator.model.ProductType;
import com.oskarro.comparator.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ComparatorApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldSaveProduct() {
        Product product = new Product(UUID.randomUUID().toString(), "PRODUCT CREATE", ProductType.FOOD);
        Product saved = productRepository.save(product);
        assertThat(saved).isNotNull();
        assertThat(productRepository.count()).isGreaterThan(0);
    }

    @Test
    public void shouldGetSavedProduct() {
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, "PRODUCT GET", ProductType.FOOD);

        productRepository.save(product);
        Optional<Product> productOptional = productRepository.findById(id);
        assertThat(productOptional).isPresent();

        Product saved = productOptional.get();
        assertThat(saved).isNotNull();
        assertThat(saved.getProductType()).isEqualTo(ProductType.FOOD);
        assertThat(saved.getName()).isEqualToIgnoringCase("Product GET");
    }

    @Test
    public void shouldUpdateSavedProduct() {
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, "PRODUCT UPDATE", ProductType.FOOD);

        Product saved = productRepository.save(product);
        saved.setProductType(ProductType.ALCOHOL);
        productRepository.save(product);

        Optional<Product> productOptional = productRepository.findById(id);
        assertThat(productOptional).isPresent();

        Product updated = productOptional.get();
        assertThat(updated).isNotNull();
        assertThat(updated.getName()).isEqualTo("PRODUCT UPDATE");
        assertThat(updated.getProductType()).isEqualTo(ProductType.ALCOHOL);
    }




}
