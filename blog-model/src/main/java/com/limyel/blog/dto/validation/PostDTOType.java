package com.limyel.blog.dto.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PostDTOTypeValidator.class)
public @interface PostDTOType {
}
