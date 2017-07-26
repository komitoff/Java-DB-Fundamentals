package application.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int minLength;
    private int maxLength;
    private boolean containsDigit;
    private boolean containsLowerCase;
    private boolean containsUpperCase;
    private boolean containsSpecialCharacter;


    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.containsDigit = password.containsDigit();
        this.containsLowerCase = password.containsLowerCase();
        this.containsUpperCase = password.containsUpperCase();
        this.containsSpecialCharacter = password.containsSpecialCharacter();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if (password.length() < this.minLength || password.length() > this.maxLength) {
            return false;
//            throw new IllegalArgumentException("Password must be between 6 and 50 symbols");
        }

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

        if (!password.matches(".*[!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?].*") && this.containsSpecialCharacter) {
            return false;
//            throw new IllegalArgumentException("Password must contains at least one special character");
        }

        return true;
    }
}
