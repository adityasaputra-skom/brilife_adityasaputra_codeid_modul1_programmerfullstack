package com.codeid.microservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codeid.microservices.validation.annotations.MinLength;

public class MinLengthValidator implements ConstraintValidator<MinLength, String> {

    private MinLength constraint;

    @Override
    public void initialize(MinLength constraintAnnotation) {
        constraint = constraintAnnotation;
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int length = value != null ? value.length() :0;
        return length >= constraint.value();
    }
    
    
}