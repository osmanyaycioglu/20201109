package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidation implements ConstraintValidator<StartWith, String> {

    private StartWith sw;

    @Override
    public void initialize(final StartWith sw) {
        this.sw = sw;

    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        String start = this.sw.value();
        return valueParam.startsWith(start);
    }

}
