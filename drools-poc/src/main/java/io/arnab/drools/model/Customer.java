package io.arnab.drools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    CustomerType type;
    int years;
    int discount;

    public Customer(CustomerType type, int numOfYears) {
        this.type = type;
        this.years = numOfYears;
    }
}

