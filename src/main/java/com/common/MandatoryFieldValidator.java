package com.common;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MandatoryFieldValidator implements ConstraintValidator<MandatoryField, Object> {
    public MandatoryFieldValidator() {
    }

    public boolean isValid(Object requiredField, ConstraintValidatorContext cxt) {
        if (requiredField != null) {
            if (requiredField instanceof String) {
                return !((String)requiredField).isEmpty();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
