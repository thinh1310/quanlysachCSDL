package nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;


public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User>
{
    @Override
    public boolean isValid (User user , ConstraintValidatorContext context) {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}
