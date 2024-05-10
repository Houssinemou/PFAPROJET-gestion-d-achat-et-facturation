package org.solution;

public class Validateur {
    private ValidationStrategy validationStrategy;

    public Validateur(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public void setValidationStrategy(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean valider(String input) {
        return validationStrategy.validate(input);
    }
}
