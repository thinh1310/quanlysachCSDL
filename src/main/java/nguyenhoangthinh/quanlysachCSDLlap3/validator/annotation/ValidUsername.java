package nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation;
import com.example.demo.validator.ValidUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)


public @interface ValidUsername {
    String message() default "username already exists0";
    Class<?>[] groups() default {} ;
    Class<? extends Payload>[] payload() default {};

}
