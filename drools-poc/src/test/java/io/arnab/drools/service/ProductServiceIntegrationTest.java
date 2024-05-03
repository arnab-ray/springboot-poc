package io.arnab.drools.service;

import io.arnab.drools.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceIntegrationTest {
    private ProductService productService;

    @BeforeEach
    public void setup() {
        productService = new ProductService();
    }


    @Test
    public void whenProductTypeElectronic_ThenLabelBarcode() {
        Product product = new Product("Microwave", "Electronic");
        product = productService.applyLabelToProduct(product);
        assertEquals("BarCode", product.getLabel());
        Assertions.assertThat(product)
                .usingRecursiveComparison()
                .isEqualTo(new Product("Microwave", "Electronic", "BarCode"));
    }

    @Test
    public void whenProductTypeBook_ThenLabelIsbn() {
        Product product = new Product("AutoBiography", "Book");
        product = productService.applyLabelToProduct(product);
        assertEquals("ISBN", product.getLabel() );
    }
}
