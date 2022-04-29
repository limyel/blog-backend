package com.limyel.blog.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PostDTOTypeValidator implements ConstraintValidator<PostDTOType, List<Long>> {

    @Override
    public boolean isValid(List<Long> tagIdList, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
