package game_store.validator;

import game_store.command.Register;
import game_store.model.bindingModel.user.RegisterUser;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {


    @Override
    public void initialize(PasswordMatching passwordMatching) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        if (obj instanceof RegisterUser) {
            RegisterUser registerUser = (RegisterUser) obj;
            return registerUser.getPassword().equals(registerUser.getConfirmPassword());
        }
        return false;
    }
}
