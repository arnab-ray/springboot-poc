package io.arnab.drools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    String name;
    String type;
    String label;

    public Product(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
