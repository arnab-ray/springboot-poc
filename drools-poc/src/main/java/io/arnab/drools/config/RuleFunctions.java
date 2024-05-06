package io.arnab.drools.config;

import org.drools.core.rule.consequence.KnowledgeHelper;
import org.slf4j.LoggerFactory;

public class RuleFunctions {
    /**
     * Log a debug message from a rule, using the rule’s package and name as the Log4J
     * category.
     */
    public static void log(final KnowledgeHelper drools, final String message,
                           final Object... parameters) {

        final String category = drools.getRule().getPackageName() + "."
                + drools.getRule().getName();
        final String formattedMessage = String.format(message, parameters);
        LoggerFactory.getLogger(category).info(formattedMessage);
    }
}
