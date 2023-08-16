package com.example.board.wantedpreonboardingbackend.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE_USE;

@Documented
@Target({ TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UpdateValidator.class})
public @interface UpdateDTOCheck {
    String message() default "title, content, attach are empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String title();
    String content();
    String attach();
}
