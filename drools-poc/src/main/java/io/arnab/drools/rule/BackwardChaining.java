package io.arnab.drools.rule;

import io.arnab.drools.config.DroolsBeanFactory;
import io.arnab.drools.model.Fact;
import io.arnab.drools.model.Result;
import org.kie.api.runtime.KieSession;

public class BackwardChaining {
    public static void main(String[] args) {
        Result result = new BackwardChaining().backwardChaining();
        System.out.println(result.getValue());
        result.getFacts().forEach(System.out::println);
    }

    public Result backwardChaining() {
        Result result = new Result();
        KieSession kSession = new DroolsBeanFactory().getKieSession();
        kSession.setGlobal("result", result);
        kSession.insert(new Fact("Asia", "Planet Earth"));
        kSession.insert(new Fact("China", "Asia"));
        kSession.insert(new Fact("Great Wall of China", "China"));

        kSession.fireAllRules();

        return result;
    }
}
