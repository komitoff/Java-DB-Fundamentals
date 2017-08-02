package game_store.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private boolean containsDigit;
    private boolean containsLowerCase;
    private boolean containsUpperCase;

    @Override
    public void initialize(Password password) {


    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (!password.matches(".*[a-z].*") && this.containsLowerCase) {
            return false;
//            throw new IllegalArgumentException("Password must contains at least one small letter");
        }

        if (!password.matches(".*[A-Z].*") && this.containsUpperCase) {
            return false;
//            throw new IllegalArgumentException("Password must contains at least one big letter");
        }

        if (!password.matches(".*[0-9].*") && this.containsDigit) {
            return false;
//            throw new IllegalArgumentException("Password must contains at least one digit");
        }
        return true;
    }
}
