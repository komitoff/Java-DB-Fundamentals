package application.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator  implements ConstraintValidator<Email, String> {


    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if (!email.matches("[a-zA-Z0-9].*@[a-zA-Z0-9].*\\.[a-zA-Z].*")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        return true;
    }
}
