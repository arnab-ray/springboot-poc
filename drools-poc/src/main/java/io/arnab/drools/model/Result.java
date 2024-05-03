package io.arnab.drools.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Result {
    private String value;
    private List<String> facts = new ArrayList<>();

    public void addFact(String fact) {
        this.facts.add(fact);
    }
}
