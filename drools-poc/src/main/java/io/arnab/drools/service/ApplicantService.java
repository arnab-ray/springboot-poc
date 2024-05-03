package io.arnab.drools.service;

import io.arnab.drools.model.SuggestedRole;
import io.arnab.drools.config.DroolsBeanFactory;
import io.arnab.drools.model.Applicant;
import org.kie.api.runtime.KieSession;

public class ApplicantService {
    KieSession kieSession = new DroolsBeanFactory().getKieSession();

    public void suggestARoleForApplicant(Applicant applicant, SuggestedRole suggestedRole) {
        try {
            kieSession.insert(applicant);
            kieSession.setGlobal("suggestedRole", suggestedRole);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        System.out.println(suggestedRole.getRole());

    }
}
