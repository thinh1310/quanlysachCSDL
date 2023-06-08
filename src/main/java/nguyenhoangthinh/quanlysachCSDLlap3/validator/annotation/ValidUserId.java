package nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({TYPE , FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUserIdValidator.class)
@Documented
public @interface ValidUserId {
    String message() default "Invalid User ID";
    Class<?> [] groups() default {};
            Class<? extends Payload>[] payload() default {};
}
