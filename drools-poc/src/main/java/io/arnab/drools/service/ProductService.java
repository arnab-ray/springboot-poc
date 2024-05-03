package io.arnab.drools.service;

import io.arnab.drools.model.Product;
import io.arnab.drools.config.DroolsBeanFactory;
import org.kie.api.runtime.KieSession;

public class ProductService {
    private final KieSession kieSession = new DroolsBeanFactory().getKieSession();

    public Product applyLabelToProduct(Product product){
        try {
            kieSession.insert(product);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        System.out.println(product.getLabel());
        return product;

    }
}
