package io.arnab.drools;

import io.arnab.drools.config.DroolsBeanFactory;
import io.arnab.drools.model.Result;
import io.arnab.drools.model.Fact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackwardChainingIntegrationTest {
    private Result result;
    private KieSession kSession;

    @BeforeEach
    public void before() {
        result = new Result();
        kSession = new DroolsBeanFactory().getKieSession();
    }

    @Test
    public void whenWallOfChinaIsGiven_ThenItBelongsToPlanetEarth() {

        kSession.setGlobal("result", result);
        kSession.insert(new Fact("Asia", "Planet Earth"));
        kSession.insert(new Fact("China", "Asia"));
        kSession.insert(new Fact("Great Wall of China", "China"));

        kSession.fireAllRules();

        // Assert Decision one
        assertEquals(result.getValue(), "Decision one taken: Great Wall of China BELONGS TO Planet Earth");
    }
}
