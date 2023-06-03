package nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername,String> {
    @Autowired
    private IUserReposity userReposity;
    @Override
    public boolean isValis(String username, ConstraintValidatorContext context)
    {
        if(userReposity ==  null)
            return true;
        return userReposity.findByUsername(username) == null;

    }
}
